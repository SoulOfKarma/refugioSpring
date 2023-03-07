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
@Table(name = "tbl_provincia")
public class Provincia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_provincia")
	private Long idProvincia;

	@Column(name = "nombre_provincia")
	private String nombreProvincia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_region")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Region region;

	public Provincia() {
	}

	public Provincia(Long idProvincia, String nombreProvincia, Region region) {
		super();
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;
		this.region = region;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	private static final long serialVersionUID = 1L;

}
