package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_prestacion")
public class TipoPrestacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_prest")
	private Long idTipoPrestacion;
	
	@Column(name = "nombre_tipo_prest")
    private String nombreTipoPrestacion;

	public TipoPrestacion() {
	}

	public TipoPrestacion(Long idTipoPrestacion, String nombreTipoPrestacion) {
		this.idTipoPrestacion = idTipoPrestacion;
		this.nombreTipoPrestacion = nombreTipoPrestacion;
	}

	public Long getIdTipoPrestacion() {
		return idTipoPrestacion;
	}

	public void setIdTipoPrestacion(Long idTipoPrestacion) {
		this.idTipoPrestacion = idTipoPrestacion;
	}

	public String getNombreTipoPrestacion() {
		return nombreTipoPrestacion;
	}

	public void setNombreTipoPrestacion(String nombreTipoPrestacion) {
		this.nombreTipoPrestacion = nombreTipoPrestacion;
	}

	private static final long serialVersionUID = 1L;
}
