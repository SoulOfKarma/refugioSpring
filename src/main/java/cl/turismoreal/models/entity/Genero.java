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
@Table(name = "tbl_genero")
public class Genero implements Serializable {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Integer idGenero;

	@NotEmpty(message = "No puede estar vacío")
    @Size(min = 3, max = 20)
    @Column(name = "descripcion_genero")
    private String descripcionGenero;

    public Genero() {
    }

    public Genero(Integer idGenero, String descripcionGenero) {
        this.idGenero = idGenero;
        this.descripcionGenero = descripcionGenero;
    }
    
    public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescripcionGenero() {
		return descripcionGenero;
	}

	public void setDescripcionGenero(String descripcionGenero) {
		this.descripcionGenero = descripcionGenero;
	}

	private static final long serialVersionUID = 1L;

}
