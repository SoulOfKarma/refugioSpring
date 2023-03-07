package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_danio")
public class TipoDanio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_danio")
	private Long idTipoDanio;
	
	@Column(name = "descripcion_danio")
    private String descripcionDanio;
	
	@Column(name = "valor_danio")
    private Integer valorDanio;

	public TipoDanio() {
	}

	public TipoDanio(Long idTipoDanio, String descripcionDanio, Integer valorDanio) {
		this.idTipoDanio = idTipoDanio;
		this.descripcionDanio = descripcionDanio;
		this.valorDanio = valorDanio;
	}

	public Long getIdTipoDanio() {
		return idTipoDanio;
	}

	public void setIdTipoDanio(Long idTipoDanio) {
		this.idTipoDanio = idTipoDanio;
	}

	public String getDescripcionDanio() {
		return descripcionDanio;
	}

	public void setDescripcionDanio(String descripcionDanio) {
		this.descripcionDanio = descripcionDanio;
	}

	public Integer getValorDanio() {
		return valorDanio;
	}

	public void setValorDanio(Integer valorDanio) {
		this.valorDanio = valorDanio;
	}

	private static final long serialVersionUID = 1L;
}
