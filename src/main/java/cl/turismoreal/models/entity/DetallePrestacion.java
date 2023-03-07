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
@Table(name = "tbl_detalle_prestacion")
public class DetallePrestacion implements Serializable {
	
	@Id
    @Column(name = "id_det_prest")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetPrestacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prestacion")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "prestaciones" })
	private Prestacion prestacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dep")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "prestaciones" })
    private Departamento departamento;
	
	public DetallePrestacion() {
	}

	public DetallePrestacion(Prestacion prestacion, Departamento departamento) {
		this.prestacion = prestacion;
		this.departamento = departamento;
	}

	public Prestacion getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	private static final long serialVersionUID = 1L;
}
