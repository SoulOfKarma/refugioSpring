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
@Table(name = "tbl_gastos_departamento")
public class GastosDepartamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gasto")
	private Long idGasto;
	
	@Column(name = "nombre_gasto")
    private String nombreGasto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_gasto")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private TipoGasto tipoGasto;

	public GastosDepartamento() {
	}

	public GastosDepartamento(Long idGasto, String nombreGasto, TipoGasto tipoGasto) {
		this.idGasto = idGasto;
		this.nombreGasto = nombreGasto;
		this.tipoGasto = tipoGasto;
	}

	public Long getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(Long idGasto) {
		this.idGasto = idGasto;
	}

	public String getNombreGasto() {
		return nombreGasto;
	}

	public void setNombreGasto(String nombreGasto) {
		this.nombreGasto = nombreGasto;
	}

	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	private static final long serialVersionUID = 1L;
}
