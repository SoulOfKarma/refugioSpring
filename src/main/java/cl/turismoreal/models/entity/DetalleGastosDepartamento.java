package cl.turismoreal.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_detalle_gastos_dep")
public class DetalleGastosDepartamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_dep")
	private Departamento departamento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_gasto")
    private GastosDepartamento gasto;
	
	@Column(name = "precio_gasto")
    private Integer precioGasto;
	
	@Column(name = "fecha_gasto")
    private Date fechaGasto;

	public DetalleGastosDepartamento() {
	}

	public DetalleGastosDepartamento(Departamento departamento, GastosDepartamento gasto, Integer precioGasto,
			Date fechaGasto) {
		this.departamento = departamento;
		this.gasto = gasto;
		this.precioGasto = precioGasto;
		this.fechaGasto = fechaGasto;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public GastosDepartamento getGasto() {
		return gasto;
	}

	public void setGasto(GastosDepartamento gasto) {
		this.gasto = gasto;
	}

	public Integer getPrecioGasto() {
		return precioGasto;
	}

	public void setPrecioGasto(Integer precioGasto) {
		this.precioGasto = precioGasto;
	}

	public Date getFechaGasto() {
		return fechaGasto;
	}

	public void setFechaGasto(Date fechaGasto) {
		this.fechaGasto = fechaGasto;
	}

	private static final long serialVersionUID = 1L;
}
