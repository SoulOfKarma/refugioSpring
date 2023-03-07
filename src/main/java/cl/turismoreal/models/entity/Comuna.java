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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_comuna")
public class Comuna implements Serializable {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_comuna")
    private Long idComuna;

	@NotEmpty(message = "No puede estar vacío")
    @Size(min = 3, max = 100)
    @Column(name = "nombre_comuna")
    private String nombreComuna;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Provincia provincia;

    public Comuna() {
    }

    public Comuna(Long idComuna, String nombreComuna, Provincia provincia) {
        this.idComuna = idComuna;
        this.nombreComuna = nombreComuna;
        this.provincia = provincia;
    }
	
	public Long getIdComuna() {
		return idComuna;
	}

	public void setIdComuna(Long idComuna) {
		this.idComuna = idComuna;
	}

	public String getNombreComuna() {
		return nombreComuna;
	}

	public void setNombreComuna(String nombreComuna) {
		this.nombreComuna = nombreComuna;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	private static final long serialVersionUID = 1L;

}
