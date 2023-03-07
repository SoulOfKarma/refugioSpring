package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_empleado")
public class TipoEmpleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_emp")
	private Long idTipoEmpleado;

	@Column(name = "cargo_tipo_emp")
	private String nombreTipo;

	public TipoEmpleado() {
	}

	public TipoEmpleado(Long idTipoEmpleado, String nombreTipo) {
		this.idTipoEmpleado = idTipoEmpleado;
		this.nombreTipo = nombreTipo;
	}

	public Long getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	public void setIdTipoEmpleado(Long idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	private static final long serialVersionUID = 1L;

}
