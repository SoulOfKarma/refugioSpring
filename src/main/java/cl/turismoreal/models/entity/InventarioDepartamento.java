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
@Table(name = "tbl_inventario")
public class InventarioDepartamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inventario")
	private Long idInventario;
	
	@Column(name = "nombre_objeto")
    private String nombreObjeto;
	
	@Column(name = "desc_objeto")
    private String descripcionObjeto;
	
	@Column(name = "valor_objeto")
    private Integer valorObjeto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dep")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "inventarios" })
    private Departamento departamento;

	public InventarioDepartamento() {
	}

	public InventarioDepartamento(Long idInventario, String nombreObjeto, String descripcionObjeto, Integer valorObjeto,
			Departamento departamento) {
		this.idInventario = idInventario;
		this.nombreObjeto = nombreObjeto;
		this.descripcionObjeto = descripcionObjeto;
		this.valorObjeto = valorObjeto;
		this.departamento = departamento;
	}

	public Long getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(Long idInventario) {
		this.idInventario = idInventario;
	}

	public String getNombreObjeto() {
		return nombreObjeto;
	}

	public void setNombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}

	public String getDescripcionObjeto() {
		return descripcionObjeto;
	}

	public void setDescripcionObjeto(String descripcionObjeto) {
		this.descripcionObjeto = descripcionObjeto;
	}

	public Integer getValorObjeto() {
		return valorObjeto;
	}

	public void setValorObjeto(Integer valorObjeto) {
		this.valorObjeto = valorObjeto;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	private static final long serialVersionUID = 1L;
}
