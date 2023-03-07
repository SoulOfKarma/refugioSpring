package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_detalle_danio")
public class DetalleDanio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_danio")
	private TipoDanio tipoDanio;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
    private Reserva reserva;
    
	public DetalleDanio() {
	}

	public DetalleDanio(TipoDanio tipoDanio, Reserva reserva) {
		this.tipoDanio = tipoDanio;
		this.reserva = reserva;
	}

	public TipoDanio getTipoDanio() {
		return tipoDanio;
	}

	public void setTipoDanio(TipoDanio tipoDanio) {
		this.tipoDanio = tipoDanio;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	private static final long serialVersionUID = 1L;
}
