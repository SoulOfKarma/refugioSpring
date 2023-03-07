package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_nacionalidad")
public class Nacionalidad implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_nacionalidad")
    private Long idNacionalidad;

	@NotEmpty(message = "No puede estar vacío")
    @Size(min = 3, max = 20)
    @Column(name = "nombre_nacionalidad")
    private String nombreNacionalidad;

    public Nacionalidad() {
    }

    public Nacionalidad(Long idNacionalidad, String nombreNacionalidad) {
        this.idNacionalidad = idNacionalidad;
        this.nombreNacionalidad = nombreNacionalidad;
    }
    
    public Long getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(Long idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getNombreNacionalidad() {
		return nombreNacionalidad;
	}

	public void setNombreNacionalidad(String nombreNacionalidad) {
		this.nombreNacionalidad = nombreNacionalidad;
	}

	private static final long serialVersionUID = 1L;
}
