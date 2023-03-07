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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;

	@NotEmpty(message = "No puede estar vacío")
	@Size(min = 8, max = 12, message = "El run debe contener entre 8 y 12 carácteres")
	@Column(name = "run_cli", unique = true)
	private String runCliente;

	@NotEmpty(message = "No puede estar vacío")
	@Size(min = 0, max = 15, message = "El número de documento debe contener máximo 15 carácteres")
	@Column(name = "numero_documento", unique = true)
	private String numeroDocCliente;

	@NotEmpty(message = "No puede estar vacío")
	@Size(min = 2, max = 15, message = "El nombre debe contener entre 2 y 15 carácteres")
	@Column(name = "nombre_cli")
	private String nombreCliente;

	@NotEmpty(message = "No puede estar vacío")
	@Size(min = 2, max = 15, message = "El apellido debe contener entre 8 y 12 carácteres")
	@Column(name = "apellido_cli")
	private String apellidoCliente;

	@NotNull(message = "No puede estar vacía")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_nacionalidad")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Nacionalidad nacionalidadCliente;

	@NotNull(message = "No puede estar vacía")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_genero")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Genero generoCliente;

	@NotEmpty(message = "No puede estar vacío")
	@Email(message = "Este email no es correcto")
	@Size(min = 0, max = 50, message = "El email debe contener máximo 50 carácteres")
	@Column(name = "email_cli", unique = true)
	private String username;

	//@NotEmpty(message = "No puede estar vacío")
	@Size(min = 8, message = "La contraseña debe tener mínimo 8 carácteres")
	@Column(name = "pass_cli", length = 60)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@NotEmpty(message = "No puede estar vacío")
	@Size(min = 0, max = 50, message = "La dirección debe contener máximo 50 carácteres")
	@Column(name = "direc_cli")
	private String direccionCliente;

	@NotNull(message = "No puede estar vacía")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comuna")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Comuna comunaCliente;

	@NotNull(message = "No puede estar vacío")
	@Column(name = "fecha_nac_cli")
	@Temporal(TemporalType.DATE)
	private Date fechaNacCliente;

	@NotEmpty(message = "No puede estar vacío")
	@Size(min = 8, max = 12, message = "El teléfono debe contener entre 8 y 12 carácteres")
	@Column(name = "tel_cli")
	private String telefonoCliente;

	@Column(name = "estado_cli")
	private Boolean enable;

	@Column(name = "foto_perfil_cli", unique = true)
	private String fotoPerfilCliente;

	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cliente" })
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Reserva> reservas;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cliente" })
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Comentario> comentarios;
	
	@PrePersist
	public void prePersist() {
		fechaRegistro = new Date();
	}

	public Cliente() {
		this.reservas = new ArrayList<>();
		this.comentarios = new ArrayList<>();
	}

	public Cliente(String runCliente, String numeroDocCliente, String nombreCliente, String apellidoCliente,
			Nacionalidad nacionalidadCliente, Genero generoCliente, String username, String password,
			String direccionCliente, Comuna comunaCliente, Date fechaNacCliente, String telefonoCliente, Boolean enable,
			String fotoPerfilCliente, Date fechaRegistro) {
		this.runCliente = runCliente;
		this.numeroDocCliente = numeroDocCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.nacionalidadCliente = nacionalidadCliente;
		this.generoCliente = generoCliente;
		this.username = username;
		this.password = password;
		this.direccionCliente = direccionCliente;
		this.comunaCliente = comunaCliente;
		this.fechaNacCliente = fechaNacCliente;
		this.telefonoCliente = telefonoCliente;
		this.enable = enable;
		this.fotoPerfilCliente = fotoPerfilCliente;
		this.fechaRegistro = fechaRegistro;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNumeroDocCliente() {
		return numeroDocCliente;
	}

	public void setNumeroDocCliente(String numeroDocCliente) {
		this.numeroDocCliente = numeroDocCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public Nacionalidad getNacionalidadCliente() {
		return nacionalidadCliente;
	}

	public void setNacionalidadCliente(Nacionalidad nacionalidadCliente) {
		this.nacionalidadCliente = nacionalidadCliente;
	}

	public Genero getGeneroCliente() {
		return generoCliente;
	}

	public void setGeneroCliente(Genero generoCliente) {
		this.generoCliente = generoCliente;
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

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public Comuna getComunaCliente() {
		return comunaCliente;
	}

	public void setComunaCliente(Comuna comunaCliente) {
		this.comunaCliente = comunaCliente;
	}

	public Date getFechaNacCliente() {
		return fechaNacCliente;
	}

	public void setFechaNacCliente(Date fechaNacCliente) {
		this.fechaNacCliente = fechaNacCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getFotoPerfilCliente() {
		return fotoPerfilCliente;
	}

	public void setFotoPerfilCliente(String fotoPerfilCliente) {
		this.fotoPerfilCliente = fotoPerfilCliente;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/*
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	*/
	private static final long serialVersionUID = 1L;
}
