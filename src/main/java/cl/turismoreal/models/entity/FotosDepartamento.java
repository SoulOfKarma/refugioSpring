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
@Table(name = "tbl_fotos_departamento")
public class FotosDepartamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto")
	private Long idFoto;
	
	@Column(name = "ruta_foto")
    private String rutaFoto;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "fotos" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dep")
    private Departamento departamento;

	public FotosDepartamento() {
	}

	public FotosDepartamento(Long idFoto, String rutaFoto, Departamento departamento) {
		this.idFoto = idFoto;
		this.rutaFoto = rutaFoto;
		this.departamento = departamento;
	}

	public Long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	private static final long serialVersionUID = 1L;
}
