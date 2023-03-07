package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_detalle_servicio_extra")
public class ServiciosReserva implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_det_ser_ext")
	private Long idServicioReserva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_reserva")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Reserva reserva;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_serv_ext")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ServicioExtra servicio;

	@Column(name = "estado")
	private Boolean estado;

	public ServiciosReserva() {
	}

	public ServiciosReserva(Long idServicioReserva, Reserva reserva, ServicioExtra servicio, Boolean estado) {
		this.idServicioReserva = idServicioReserva;
		this.reserva = reserva;
		this.servicio = servicio;
		this.estado = estado;
	}

	public Long getIdServicioReserva() {
		return idServicioReserva;
	}

	public void setIdServicioReserva(Long idServicioReserva) {
		this.idServicioReserva = idServicioReserva;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public ServicioExtra getServicio() {
		return servicio;
	}

	public void setServicio(ServicioExtra servicio) {
		this.servicio = servicio;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;
}
