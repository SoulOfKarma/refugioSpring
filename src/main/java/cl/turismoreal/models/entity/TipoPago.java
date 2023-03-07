package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_pago")
public class TipoPago implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_pago")
	private Long idTipoPago;
	
	@Column(name = "desc_tipo_pago")
    private String descripcionTipoPago;

	public TipoPago() {
	}

	public TipoPago(Long idTipoPago, String descripcionTipoPago) {
		this.idTipoPago = idTipoPago;
		this.descripcionTipoPago = descripcionTipoPago;
	}

	public Long getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(Long idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public String getDescripcionTipoPago() {
		return descripcionTipoPago;
	}

	public void setDescripcionTipoPago(String descripcionTipoPago) {
		this.descripcionTipoPago = descripcionTipoPago;
	}

	private static final long serialVersionUID = 1L;
}
