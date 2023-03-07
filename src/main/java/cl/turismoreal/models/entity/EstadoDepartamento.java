package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_estado_departamento")
public class EstadoDepartamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_est_dep")
	private Long idEstadoDepartamento;

	@Column(name = "desc_est_dep")
	private String descEstadoDepartamento;

	public EstadoDepartamento() {
	}

	public EstadoDepartamento(Long idEstadoDepartamento, String descEstadoDepartamento) {
		this.idEstadoDepartamento = idEstadoDepartamento;
		this.descEstadoDepartamento = descEstadoDepartamento;
	}

	public Long getIdEstadoDepartamento() {
		return idEstadoDepartamento;
	}

	public void setIdEstadoDepartamento(Long idEstadoDepartamento) {
		this.idEstadoDepartamento = idEstadoDepartamento;
	}

	public String getDescEstadoDepartamento() {
		return descEstadoDepartamento;
	}

	public void setDescEstadoDepartamento(String descEstadoDepartamento) {
		this.descEstadoDepartamento = descEstadoDepartamento;
	}

	private static final long serialVersionUID = 1L;
}
