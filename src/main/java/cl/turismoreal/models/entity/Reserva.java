package cl.turismoreal.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Service
@Entity
@Table(name = "tbl_reserva")
public class Reserva implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_reserva")
	private Long idReserva;

	@NotNull
	@Column(name = "codigo_reserva", unique = true)
	private String codigoReserva;

	@NotNull
	@Column(name = "fecha_reserva")
	@Temporal(TemporalType.DATE)
	private Date fechaReserva;

	@NotNull
	@Column(name = "fec_ini_res")
	@Temporal(TemporalType.DATE)
	private Date fechaInicioReserva;

	@NotNull
	@Column(name = "fec_ter_res")
	@Temporal(TemporalType.DATE)
	private Date fechaTerminoReserva;

	@NotNull
	@Column(name = "num_hues")
	private Integer numHuespedes;

	@NotNull
	@Column(name = "total_reserva")
	private Integer totalReserva;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "reservas"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dep")
	private Departamento departamento;

	@NotNull
	@Column(name = "chck")
	private Integer check;

	@Column(name = "reembolso")
	private Integer reembolso;

	@Column(name = "multa")
	private Integer multa;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "reservas" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "reservas" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "reserva" })
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reserva")
	private List<ServiciosReserva> servicios;

	public Reserva() {
		servicios = new ArrayList<>();
	}

	public Reserva(Long idReserva, String codigoReserva, Date fechaReserva,
			Date fechaInicioReserva, Date fechaTerminoReserva, Integer numHuespedes,
			Integer totalReserva, Departamento departamento, Integer check,
			Integer reembolso, Integer multa, Cliente cliente, Empleado empleado) {
		super();
		this.idReserva = idReserva;
		this.codigoReserva = codigoReserva;
		this.fechaReserva = fechaReserva;
		this.fechaInicioReserva = fechaInicioReserva;
		this.fechaTerminoReserva = fechaTerminoReserva;
		this.numHuespedes = numHuespedes;
		this.totalReserva = totalReserva;
		this.departamento = departamento;
		this.check = check;
		this.reembolso = reembolso;
		this.multa = multa;
		this.cliente = cliente;
		this.empleado = empleado;
	}

	@PrePersist
	public void prePersist() {
		fechaReserva = new Date();
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getFechaInicioReserva() {
		return fechaInicioReserva;
	}

	public void setFechaInicioReserva(Date fechaInicioReserva) {
		this.fechaInicioReserva = fechaInicioReserva;
	}

	public Date getFechaTerminoReserva() {
		return fechaTerminoReserva;
	}

	public void setFechaTerminoReserva(Date fechaTerminoReserva) {
		this.fechaTerminoReserva = fechaTerminoReserva;
	}

	public Integer getNumHuespedes() {
		return numHuespedes;
	}

	public void setNumHuespedes(Integer numHuespedes) {
		this.numHuespedes = numHuespedes;
	}

	public Integer getTotalReserva() {
		/*Integer total = 0;
		for(ServicioExtra servicio: servicios) {
			total += servicio.get
		}*/
		return totalReserva;
	}

	public void setTotalReserva(Integer totalReserva) {
		this.totalReserva = totalReserva;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Integer getCheck() {
		return check;
	}

	public void setCheck(Integer check) {
		this.check = check;
	}

	public Integer getReembolso() {
		return reembolso;
	}

	public void setReembolso(Integer reembolso) {
		this.reembolso = reembolso;
	}

	public Integer getMulta() {
		return multa;
	}

	public void setMulta(Integer multa) {
		this.multa = multa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<ServiciosReserva> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServiciosReserva> servicios) {
		this.servicios = servicios;
	}
	
	public String getRandomString(int length) {
        char[] chars = "ABCDEFGHIJKLMNOPQRST0123456789".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomStr = sb.toString();

        return randomStr;
    }

	private static final long serialVersionUID = 1L;
}
