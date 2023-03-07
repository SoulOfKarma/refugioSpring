package cl.turismoreal.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_detalle_alerta")
public class DetalleAlerta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_det_alerta")
	private Long idDetalleAlerta;
	
	@Column(name = "fecha_alerta")
    private Date fechaAlerta;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_check")
    private Long idCheck;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_alerta")
    private Long idTipoAlerta;

	public DetalleAlerta() {
	}

	public DetalleAlerta(Long idDetalleAlerta, Date fechaAlerta, Long idCheck, Long idTipoAlerta) {
		this.idDetalleAlerta = idDetalleAlerta;
		this.fechaAlerta = fechaAlerta;
		this.idCheck = idCheck;
		this.idTipoAlerta = idTipoAlerta;
	}

	public Long getIdDetalleAlerta() {
		return idDetalleAlerta;
	}

	public void setIdDetalleAlerta(Long idDetalleAlerta) {
		this.idDetalleAlerta = idDetalleAlerta;
	}

	public Date getFechaAlerta() {
		return fechaAlerta;
	}

	public void setFechaAlerta(Date fechaAlerta) {
		this.fechaAlerta = fechaAlerta;
	}

	public Long getIdCheck() {
		return idCheck;
	}

	public void setIdCheck(Long idCheck) {
		this.idCheck = idCheck;
	}

	public Long getIdTipoAlerta() {
		return idTipoAlerta;
	}

	public void setIdTipoAlerta(Long idTipoAlerta) {
		this.idTipoAlerta = idTipoAlerta;
	}

	private static final long serialVersionUID = 1L;
}
