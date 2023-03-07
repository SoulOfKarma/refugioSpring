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
@Table(name = "tbl_check")
public class Check implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_check")
	private Long idCheck;
	
	@Column(name = "codigo_reserva")
    private String codigoReserva;
	
	@Column(name = "id_cliente")
    private Long idCliente;
	
	@Column(name = "fec_chk_in")
    private String fechaCheckIn;
	
	@Column(name = "fec_chk_out")
    private String fechaCheckOut;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_reserva")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Reserva reserva;

	public Check() {
	}

	public Check(Long idCheck, String codigoReserva, Long idCliente, String fechaCheckIn, String fechaCheckOut,
			Reserva reserva) {
		this.idCheck = idCheck;
		this.codigoReserva = codigoReserva;
		this.idCliente = idCliente;
		this.fechaCheckIn = fechaCheckIn;
		this.fechaCheckOut = fechaCheckOut;
		this.reserva = reserva;
	}

	public Long getIdCheck() {
		return idCheck;
	}

	public void setIdCheck(Long idCheck) {
		this.idCheck = idCheck;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getFechaCheckIn() {
		return fechaCheckIn;
	}

	public void setFechaCheckIn(String fechaCheckIn) {
		this.fechaCheckIn = fechaCheckIn;
	}

	public String getFechaCheckOut() {
		return fechaCheckOut;
	}

	public void setFechaCheckOut(String fechaCheckOut) {
		this.fechaCheckOut = fechaCheckOut;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	private static final long serialVersionUID = 1L;
}
