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
@Table(name = "tbl_proveedor")
public class Proveedor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prov")
	private Long idProveedor;
	
	@Column(name = "nom_prov")
    private String nombreProveedor;
	
	@Column(name = "razon_social")
    private String razonSocial;
	
	@Column(name = "sucursal_prov")
    private String sucursal;
	
	@Column(name = "rut_prov")
    private String rutProveedor;
	
	@Column(name = "direc_prov")
    private String direccionProveedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comuna")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Comuna comuna;
	
	@Column(name = "contacto_prov")
    private String contactoProveedor;
	
	@Column(name = "fono_prov")
    private String fonoProveedor;
	
	@Column(name = "email_prov")
    private String emailProveedor;

	public Proveedor() {
	}

	public Proveedor(Long idProveedor, String nombreProveedor, String razonSocial, String sucursal, String rutProveedor,
			String direccionProveedor, Comuna comuna, String contactoProveedor, String fonoProveedor,
			String emailProveedor) {
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.razonSocial = razonSocial;
		this.sucursal = sucursal;
		this.rutProveedor = rutProveedor;
		this.direccionProveedor = direccionProveedor;
		this.comuna = comuna;
		this.contactoProveedor = contactoProveedor;
		this.fonoProveedor = fonoProveedor;
		this.emailProveedor = emailProveedor;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getRutProveedor() {
		return rutProveedor;
	}

	public void setRutProveedor(String rutProveedor) {
		this.rutProveedor = rutProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public String getContactoProveedor() {
		return contactoProveedor;
	}

	public void setContactoProveedor(String contactoProveedor) {
		this.contactoProveedor = contactoProveedor;
	}

	public String getFonoProveedor() {
		return fonoProveedor;
	}

	public void setFonoProveedor(String fonoProveedor) {
		this.fonoProveedor = fonoProveedor;
	}

	public String getEmailProveedor() {
		return emailProveedor;
	}

	public void setEmailProveedor(String emailProveedor) {
		this.emailProveedor = emailProveedor;
	}

	private static final long serialVersionUID = 1L;
}
