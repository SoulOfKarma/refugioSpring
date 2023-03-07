package cl.turismoreal.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_comentarios")
public class Comentario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comentario")
	private Long idComentario;
	
	@Column(name = "desc_comentario")
    private String descripcionComentario;
	
	@Column(name = "fecha_comentario")
    private Date fechaComentario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dep")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "comentarios" })
    private Departamento departamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "comentarios" })
    private Cliente cliente;
	
	@PrePersist
	public void prePersist() {
		fechaComentario = new Date();
	}

	public Comentario() {
	}

	public Comentario(Long idComentario, String descripcionComentario, Date fechaComentario, Departamento departamento,
			Cliente cliente) {
		this.idComentario = idComentario;
		this.descripcionComentario = descripcionComentario;
		this.fechaComentario = fechaComentario;
		this.departamento = departamento;
		this.cliente = cliente;
	}

	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public String getDescripcionComentario() {
		return descripcionComentario;
	}

	public void setDescripcionComentario(String descripcionComentario) {
		this.descripcionComentario = descripcionComentario;
	}

	public Date getFechaComentario() {
		return fechaComentario;
	}

	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	private static final long serialVersionUID = 1L;
}
