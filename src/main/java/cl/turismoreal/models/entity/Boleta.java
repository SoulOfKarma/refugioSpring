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
@Table(name = "tbl_boleta")
public class Boleta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_boleta")
	private Long idBoleta;
	
	@Column(name = "fecha_boleta")
    private Date fechaBoleta;
	
	@Column(name = "sub_total")
    private Integer subTotalBoleta;
	
	@Column(name = "iva")
    private Double ivaBoleta;
	
	@Column(name = "total_boleta")
    private Integer totalBoleta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_pago")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private TipoPago tipoPago;
	
	@PrePersist
	public void prePersist() {
		fechaBoleta = new Date();
	}

	public Boleta() {
		super();
	}

	public Boleta(Long idBoleta, Date fechaBoleta, Integer subTotalBoleta, Double ivaBoleta, Integer totalBoleta,
			TipoPago tipoPago) {
		super();
		this.idBoleta = idBoleta;
		this.fechaBoleta = fechaBoleta;
		this.subTotalBoleta = subTotalBoleta;
		this.ivaBoleta = ivaBoleta;
		this.totalBoleta = totalBoleta;
		this.tipoPago = tipoPago;
	}

	public Long getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(Long idBoleta) {
		this.idBoleta = idBoleta;
	}

	public Date getFechaBoleta() {
		return fechaBoleta;
	}

	public void setFechaBoleta(Date fechaBoleta) {
		this.fechaBoleta = fechaBoleta;
	}

	public Integer getSubTotalBoleta() {
		return subTotalBoleta;
	}

	public void setSubTotalBoleta(Integer subTotalBoleta) {
		this.subTotalBoleta = subTotalBoleta;
	}

	public Double getIvaBoleta() {
		return ivaBoleta;
	}

	public void setIvaBoleta(Double ivaBoleta) {
		this.ivaBoleta = ivaBoleta;
	}

	public Integer getTotalBoleta() {
		return totalBoleta;
	}

	public void setTotalBoleta(Integer totalBoleta) {
		this.totalBoleta = totalBoleta;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	private static final long serialVersionUID = 1L;
}
