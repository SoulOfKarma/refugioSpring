package cl.turismoreal.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cl.turismoreal.models.entity.Cliente;
import cl.turismoreal.models.entity.Comuna;
import cl.turismoreal.models.entity.Genero;
import cl.turismoreal.models.entity.Nacionalidad;
import cl.turismoreal.models.services.ClienteService;
import cl.turismoreal.models.services.UploadFileService;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UploadFileService uploadService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> all() {
		
		List<Cliente> clientes = this.clienteService.findAll();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/clientes/pagina/{page}")
	public Page<Cliente> all(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return this.clienteService.findAll(pageable);
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id) {
		
		Cliente clienteById = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			clienteById = this.clienteService.findById(id);
			
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la consulta al repositorio de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(clienteById == null) {
			response.put("mensaje", "El recurso: ".concat(id.toString().concat(" no existe.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(clienteById, HttpStatus.OK);
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
		
		Cliente clienteAdd = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			String passwordBcrypt = passwordEncoder.encode(cliente.getPassword());
			cliente.setPassword(passwordBcrypt);
			clienteAdd = this.clienteService.save(cliente);
			
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert al repositorio de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido creado con éxito.");
		response.put("cliente", clienteAdd);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id){
		
		Cliente clienteCurrent = clienteService.findById(id);
		Cliente clienteUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(clienteCurrent == null) {
			response.put("mensaje", "Este recurso: ".concat(id.toString().concat(" no existe, imposible editar.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			clienteCurrent.setRunCliente(cliente.getRunCliente());
			clienteCurrent.setNumeroDocCliente(cliente.getNumeroDocCliente());
			clienteCurrent.setNombreCliente(cliente.getNombreCliente());
			clienteCurrent.setApellidoCliente(cliente.getApellidoCliente());
			clienteCurrent.setNacionalidadCliente(cliente.getNacionalidadCliente());
			clienteCurrent.setGeneroCliente(cliente.getGeneroCliente());
			clienteCurrent.setDireccionCliente(cliente.getDireccionCliente());
			clienteCurrent.setComunaCliente(cliente.getComunaCliente());
			clienteCurrent.setFechaNacCliente(cliente.getFechaNacCliente());
			clienteCurrent.setTelefonoCliente(cliente.getTelefonoCliente());
			clienteCurrent.setFotoPerfilCliente(cliente.getFotoPerfilCliente());
			
			clienteUpdated = clienteService.save(clienteCurrent);
			
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al tratar de actualizar el repositorio.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido actualizado con éxito.");
		response.put("cliente", clienteUpdated);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			Cliente cliente = clienteService.findById(id);
			
			String nombreFotoAnterior = cliente.getFotoPerfilCliente();
			
			uploadService.eliminar(nombreFotoAnterior);
			
			clienteService.delete(id);
			
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al tratar de eliminar el repositorio.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido eliminado con éxito.");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		
		Cliente cliente = clienteService.findById(id);
		
		if(!archivo.isEmpty()) {
			
			String nombreArchivo = null;

			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior = cliente.getFotoPerfilCliente();
			
			uploadService.eliminar(nombreFotoAnterior);
		
			cliente.setFotoPerfilCliente(nombreArchivo);
			
			clienteService.save(cliente);
			
			response.put("cliente", cliente);
			response.put("mensaje", "Tu foto de perfil "+ nombreArchivo +" ha sido subida correctamente!");
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {
		
		Resource recurso = null;
		
		try {
			recurso = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filemame=\""+ recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
	@GetMapping("/clientes/comunas")
	public List<Comuna> allComunas() {
		return clienteService.findAllComunas();
	}
	
	@GetMapping("/clientes/nacionalidades")
	public List<Nacionalidad> allNacionalidades() {
		return clienteService.findAllNacionalidades();
	}
	
	@GetMapping("/clientes/generos")
	public List<Genero> allGeneros() {
		return clienteService.findAllGeneros();
	}
}
