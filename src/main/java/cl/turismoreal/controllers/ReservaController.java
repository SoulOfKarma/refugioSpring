package cl.turismoreal.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.turismoreal.models.entity.Cliente;
import cl.turismoreal.models.entity.Departamento;
import cl.turismoreal.models.entity.Empleado;
import cl.turismoreal.models.entity.Reserva;
import cl.turismoreal.models.entity.ReservaFormato;
import cl.turismoreal.models.services.ClienteService;
import cl.turismoreal.models.services.DepartamentoService;
import cl.turismoreal.models.services.EmpleadoService;
import cl.turismoreal.models.services.MailService;
import cl.turismoreal.models.services.ReservaService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins= "*")
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private MailService notificationService;
	
	@GetMapping("/reservas")
	public ResponseEntity<List<Reserva>> all() {
		List<Reserva> reservas = this.reservaService.findAll();
		return new ResponseEntity<>(reservas, HttpStatus.OK);
	}
	
	@GetMapping("/reservas/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id) {
		Reserva reservaById = null;
		Map<String, Object> response = new HashMap<>();
		try {
			reservaById = this.reservaService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta al repositorio de datos.");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(reservaById == null) {
			response.put("Mensaje", "Este recurso: ".concat(id.toString().concat(" no existe.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Reserva>(reservaById, HttpStatus.OK);
	}
	
	@PostMapping("/reservas")
	public ResponseEntity<?> create(@Valid @RequestBody ReservaFormato reservaForm, BindingResult result) {
		
		Reserva reserva = new Reserva();
		Reserva reservaAdd = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			Departamento dpto = this.departamentoService.findById(reservaForm.getDepartamento());
			Cliente cli = this.clienteService.findById(reservaForm.getCliente());
			Empleado emp = this.empleadoService.findById(reservaForm.getEmpleado());

			reserva.setFechaInicioReserva(reservaForm.getFechaInicioReserva());
			reserva.setFechaTerminoReserva(reservaForm.getFechaTerminoReserva());
			reserva.setNumHuespedes(reservaForm.getNumHuespedes());
			reserva.setTotalReserva(reservaForm.getTotalReserva());
			reserva.setDepartamento(dpto);
			reserva.setCheck(reservaForm.getCheck());
			reserva.setReembolso(reservaForm.getReembolso());
			reserva.setMulta(reservaForm.getMulta());
			reserva.setCliente(cli);
			reserva.setEmpleado(emp);
			
			Reserva res = new Reserva();
			String valor = res.getRandomString(9);
			
			reserva.setCodigoReserva(valor);
			reservaAdd = this.reservaService.save(reserva);
			
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert al repositorio de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Reserva creada con éxito.");
		response.put("cliente", reservaAdd);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/reservas/checkin/{id}")
	public ResponseEntity<?> checkin(@PathVariable Long id) throws MessagingException {
		
		Cliente cliente = null;
		String codigo = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			Reserva reserva = this.reservaService.findById(id);
			codigo = reserva.getCodigoReserva();
			cliente = reserva.getCliente();
			cliente.getIdCliente();
			this.reservaService.findFirstByCliente(cliente);
			
			try {
				notificationService.sendEmailWithAttachment(cliente, codigo);
			} catch (MailException mailException) {
				System.out.println(mailException);
				response.put("Mensaje", "Error al enviar email.");
				response.put("Error", mailException.getMessage().concat(": ").concat(mailException.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta al repositorio de datos.");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Email enviado con éxito a " + cliente.getUsername());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/reservas/activar/{codigo}")
	public ResponseEntity<?> activarReserva(@PathVariable String codigo) {
		
		Reserva reservaCurrent = this.reservaService.findByCodigo(codigo);
		Reserva reservaUpdate = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			if (reservaCurrent.getCheck()==0) {
				reservaCurrent.setCheck(1);
				reservaUpdate = reservaService.save(reservaCurrent);
			} else {
				reservaCurrent.setCheck(0);
				reservaUpdate = reservaService.save(reservaCurrent);
			}
			
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al tratar de actualizar el repositorio.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La reserva " + reservaUpdate.getCodigoReserva() + " ha sido activada con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
