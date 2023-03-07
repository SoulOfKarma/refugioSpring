package cl.turismoreal.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_empleado")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	private Long idEmpleado;

	@Column(name = "run_emp", unique = true)
	private String runEmpleado;

	@Column(name = "nombre_emp")
	private String nombreEmpleado;

	@Column(name = "apellido_emp")
	private String apellidoEmpleado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_genero")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Genero generoEmpleado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_nacionalidad")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Nacionalidad nacionalidadEmpleado;

	@Column(name = "email_emp")
	private String username;

	@Column(name = "pass_emp", length = 60)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@Column(name = "direc_emp")
	private String direccionEmpleado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comuna")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Comuna comunaEmpleado;

	@Column(name = "fecha_nac_emp")
	@Temporal(TemporalType.DATE)
	private Date fechaNacEmpleado;

	@Column(name = "tel_emp")
	private String telefonoEmpleado;

	@Column(name = "estado_emp")
	private Boolean enable;

	@Column(name = "foto_perfil_emp")
	private String fotoPerfilEmpleado;

	@Column(name = "salario")
	private String salarioEmpleado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_emp")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoEmpleado tipoEmpleado;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "empleado"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado")
	private List<Reserva> reservas;

	public Empleado() {
		this.reservas = new ArrayList<>();
	}

	public Empleado(Long idEmpleado, String runEmpleado, String nombreEmpleado, String apellidoEmpleado,
			Genero generoEmpleado, Nacionalidad nacionalidadEmpleado, String username, String password,
			String direccionEmpleado, Comuna comunaEmpleado, Date fechaNacEmpleado, String telefonoEmpleado,
			Boolean enable, String fotoPerfilEmpleado, String salarioEmpleado, TipoEmpleado tipoEmpleado) {
		super();
		this.idEmpleado = idEmpleado;
		this.runEmpleado = runEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.generoEmpleado = generoEmpleado;
		this.nacionalidadEmpleado = nacionalidadEmpleado;
		this.username = username;
		this.password = password;
		this.direccionEmpleado = direccionEmpleado;
		this.comunaEmpleado = comunaEmpleado;
		this.fechaNacEmpleado = fechaNacEmpleado;
		this.telefonoEmpleado = telefonoEmpleado;
		this.enable = enable;
		this.fotoPerfilEmpleado = fotoPerfilEmpleado;
		this.salarioEmpleado = salarioEmpleado;
		this.tipoEmpleado = tipoEmpleado;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getRunEmpleado() {
		return runEmpleado;
	}

	public void setRunEmpleado(String runEmpleado) {
		this.runEmpleado = runEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public Genero getGeneroEmpleado() {
		return generoEmpleado;
	}

	public void setGeneroEmpleado(Genero generoEmpleado) {
		this.generoEmpleado = generoEmpleado;
	}

	public Nacionalidad getNacionalidadEmpleado() {
		return nacionalidadEmpleado;
	}

	public void setNacionalidadEmpleado(Nacionalidad nacionalidadEmpleado) {
		this.nacionalidadEmpleado = nacionalidadEmpleado;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccionEmpleado() {
		return direccionEmpleado;
	}

	public void setDireccionEmpleado(String direccionEmpleado) {
		this.direccionEmpleado = direccionEmpleado;
	}

	public Comuna getComunaEmpleado() {
		return comunaEmpleado;
	}

	public void setComunaEmpleado(Comuna comunaEmpleado) {
		this.comunaEmpleado = comunaEmpleado;
	}

	public Date getFechaNacEmpleado() {
		return fechaNacEmpleado;
	}

	public void setFechaNacEmpleado(Date fechaNacEmpleado) {
		this.fechaNacEmpleado = fechaNacEmpleado;
	}

	public String getTelefonoEmpleado() {
		return telefonoEmpleado;
	}

	public void setTelefonoEmpleado(String telefonoEmpleado) {
		this.telefonoEmpleado = telefonoEmpleado;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getFotoPerfilEmpleado() {
		return fotoPerfilEmpleado;
	}

	public void setFotoPerfilEmpleado(String fotoPerfilEmpleado) {
		this.fotoPerfilEmpleado = fotoPerfilEmpleado;
	}

	public String getSalarioEmpleado() {
		return salarioEmpleado;
	}

	public void setSalarioEmpleado(String salarioEmpleado) {
		this.salarioEmpleado = salarioEmpleado;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	private static final long serialVersionUID = 1L;
}
