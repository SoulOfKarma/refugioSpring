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
@Table(name = "tbl_servicio_extra")
public class ServicioExtra implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_serv_ext")
	private Long idServicioExtra;
	
	@Column(name = "nom_serv_ext")
	private String nombreServExtra;
	
	@Column(name = "precio_serv_ext")
	private Integer precio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prov")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Proveedor proveedor;

	public ServicioExtra() {
	}

	public ServicioExtra(Long idServicioExtra, String nombreServExtra, Integer precio, Proveedor proveedor) {
		this.idServicioExtra = idServicioExtra;
		this.nombreServExtra = nombreServExtra;
		this.precio = precio;
		this.proveedor = proveedor;
	}

	public Long getIdServicioExtra() {
		return idServicioExtra;
	}

	public void setIdServicioExtra(Long idServicioExtra) {
		this.idServicioExtra = idServicioExtra;
	}

	public String getNombreServExtra() {
		return nombreServExtra;
	}

	public void setNombreServExtra(String nombreServExtra) {
		this.nombreServExtra = nombreServExtra;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	private static final long serialVersionUID = 1L;

}
