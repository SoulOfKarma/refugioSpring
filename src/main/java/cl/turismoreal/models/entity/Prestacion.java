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
@Table(name = "tbl_prestacion")
public class Prestacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestacion")
	private Long idPrestacion;
	
	@Column(name = "nombre_prestacion")
    private String nombrePrestacion;
	
	@Column(name = "desc_prestacion")
    private String descripcionPrestacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_prest")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private TipoPrestacion tipoPrestacion;

	public Prestacion() {
	}

	public Prestacion(Long idPrestacion, String nombrePrestacion, String descripcionPrestacion,
			TipoPrestacion tipoPrestacion) {
		this.idPrestacion = idPrestacion;
		this.nombrePrestacion = nombrePrestacion;
		this.descripcionPrestacion = descripcionPrestacion;
		this.tipoPrestacion = tipoPrestacion;
	}

	public Long getIdPrestacion() {
		return idPrestacion;
	}

	public void setIdPrestacion(Long idPrestacion) {
		this.idPrestacion = idPrestacion;
	}

	public String getNombrePrestacion() {
		return nombrePrestacion;
	}

	public void setNombrePrestacion(String nombrePrestacion) {
		this.nombrePrestacion = nombrePrestacion;
	}

	public String getDescripcionPrestacion() {
		return descripcionPrestacion;
	}

	public void setDescripcionPrestacion(String descripcionPrestacion) {
		this.descripcionPrestacion = descripcionPrestacion;
	}

	public TipoPrestacion getTipoPrestacion() {
		return tipoPrestacion;
	}

	public void setTipoPrestacion(TipoPrestacion tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	private static final long serialVersionUID = 1L;
}
