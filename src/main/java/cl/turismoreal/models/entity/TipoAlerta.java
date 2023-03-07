package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_alerta")
public class TipoAlerta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_alerta")
	private Long idTipoAlerta;
	
	@Column(name = "descripcion_alerta")
    private String descripcionTipoAlerta;

	public TipoAlerta() {
		super();
	}

	public TipoAlerta(Long idTipoAlerta, String descripcionTipoAlerta) {
		super();
		this.idTipoAlerta = idTipoAlerta;
		this.descripcionTipoAlerta = descripcionTipoAlerta;
	}

	public Long getIdTipoAlerta() {
		return idTipoAlerta;
	}

	public void setIdTipoAlerta(Long idTipoAlerta) {
		this.idTipoAlerta = idTipoAlerta;
	}

	public String getDescripcionTipoAlerta() {
		return descripcionTipoAlerta;
	}

	public void setDescripcionTipoAlerta(String descripcionTipoAlerta) {
		this.descripcionTipoAlerta = descripcionTipoAlerta;
	}

	private static final long serialVersionUID = 1L;
}