package cl.turismoreal.models.entity;

import java.util.Date;

public class ReservaFormato {
	
	private Date fechaInicioReserva;
	private Date fechaTerminoReserva;
	private Integer numHuespedes;
	private Integer totalReserva;
	private Long departamento;
	private Integer check;
	private Integer reembolso;
	private Integer multa;
	private Long cliente;
	private Long empleado;
	
	public ReservaFormato() {
	}

	public Date getFechaInicioReserva() {
		return fechaInicioReserva;
	}

	public void setFechaInicioReserva(Date fechaInicioReserva) {
		this.fechaInicioReserva = fechaInicioReserva;
	}

	public Date getFechaTerminoReserva() {
		return fechaTerminoReserva;
	}

	public void setFechaTerminoReserva(Date fechaTerminoReserva) {
		this.fechaTerminoReserva = fechaTerminoReserva;
	}

	public Integer getNumHuespedes() {
		return numHuespedes;
	}

	public void setNumHuespedes(Integer numHuespedes) {
		this.numHuespedes = numHuespedes;
	}

	public Integer getTotalReserva() {
		return totalReserva;
	}

	public void setTotalReserva(Integer totalReserva) {
		this.totalReserva = totalReserva;
	}

	public Long getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Long departamento) {
		this.departamento = departamento;
	}

	public Integer getCheck() {
		return check;
	}

	public void setCheck(Integer check) {
		this.check = check;
	}

	public Integer getReembolso() {
		return reembolso;
	}

	public void setReembolso(Integer reembolso) {
		this.reembolso = reembolso;
	}

	public Integer getMulta() {
		return multa;
	}

	public void setMulta(Integer multa) {
		this.multa = multa;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Long getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Long empleado) {
		this.empleado = empleado;
	}
}
