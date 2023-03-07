package cl.turismoreal.models.entity;

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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tbl_departamento")
public class Departamento implements Serializable {

	@Id
    @Column(name = "id_dep")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;

    @Column(name = "rol_dep", unique = true)
    private Integer rolDepartamento;

    @Column(name = "direc_dep")
    private String direccionDepartamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comuna")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Comuna comuna;

    @Column(name = "num_piso_dep")
    private Integer numeroPiso;

    @Column(name = "valor_compra_dep")
    private Integer valorCompraDep;

    @Column(name = "num_dep")
    private Integer numeroDepartamento;

    @Column(name = "cant_habitaciones")
    private Integer cantidadHabitaciones;

    @Column(name = "cant_camas")
    private Integer cantidadCamas;

    @Column(name = "cant_huespedes")
    private Integer cantidadHuespedes;

    @Column(name = "cant_banios")
    private Integer cantidadBanios;

    @Column(name = "fec_const")
    @Temporal(TemporalType.DATE)
    private Date fechaConstruccion;

    @Column(name = "metros_cuadrados")
    private Integer metrosCuadrados;

    @Column(name = "valor_arriendo")
    private Integer valorArriendo;

    @Column(name = "valorizacion")
    private Integer valorizacion;

    @Column(name = "nombre_edificio")
    private String nombreEdificio;

    @Column(name = "desc_arriendo")
    private String descripcionArriendo;

    @Column(name = "pol_arriendo")
    private String politicaArriendo;

    @Column(name = "info_compl")
    private String infCompl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_est_dep")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private EstadoDepartamento estadoDep;
    
    @Column(name = "fec_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegisto;

    @Column(name = "usado")
    private Integer usado;
    
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "departamento" })
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	private List<FotosDepartamento> fotos;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "departamento" })
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	private List<InventarioDepartamento> inventarios;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "departamento" })
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	private List<DetallePrestacion> prestaciones;
	/*
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "departamento" })
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	private List<Reserva> reservas;
	*/
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "departamento" })
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	private List<Comentario> comentarios;
	
    public Departamento() {
    	this.fotos = new ArrayList<>();
    	this.inventarios = new ArrayList<>();
    	this.prestaciones = new ArrayList<>();
    	//this.reservas = new ArrayList<>();
    	this.comentarios = new ArrayList<>();
    }

    public Departamento(Integer rolDepartamento, String direccionDepartamento, Comuna comuna, Integer numeroPiso,
                        Integer valorCompraDep, Integer numeroDepartamento, Integer cantidadHabitaciones, Integer cantidadCamas,
                        Integer cantidadHuespedes, Integer cantidadBanios, Date fechaConstruccion, Integer metrosCuadrados,
                        Integer valorArriendo, Integer valorizacion, String nombreEdificio, String descripcionArriendo,
                        String politicaArriendo, String infCompl, EstadoDepartamento estadoDep,
                        Date fechaRegisto, Integer usado) {
        this.rolDepartamento = rolDepartamento;
        this.direccionDepartamento = direccionDepartamento;
        this.comuna = comuna;
        this.numeroPiso = numeroPiso;
        this.valorCompraDep = valorCompraDep;
        this.numeroDepartamento = numeroDepartamento;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.cantidadCamas = cantidadCamas;
        this.cantidadHuespedes = cantidadHuespedes;
        this.cantidadBanios = cantidadBanios;
        this.fechaConstruccion = fechaConstruccion;
        this.metrosCuadrados = metrosCuadrados;
        this.valorArriendo = valorArriendo;
        this.valorizacion = valorizacion;
        this.nombreEdificio = nombreEdificio;
        this.descripcionArriendo = descripcionArriendo;
        this.politicaArriendo = politicaArriendo;
        this.infCompl = infCompl;
        this.estadoDep = estadoDep;
        this.fechaRegisto = fechaRegisto;
        this.usado = usado;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Integer getRolDepartamento() {
        return rolDepartamento;
    }

    public void setRolDepartamento(Integer rolDepartamento) {
        this.rolDepartamento = rolDepartamento;
    }

    public String getDireccionDepartamento() {
        return direccionDepartamento;
    }

    public void setDireccionDepartamento(String direccionDepartamento) {
        this.direccionDepartamento = direccionDepartamento;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Integer getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(Integer numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public Integer getValorCompraDep() {
        return valorCompraDep;
    }

    public void setValorCompraDep(Integer valorCompraDep) {
        this.valorCompraDep = valorCompraDep;
    }

    public Integer getNumeroDepartamento() {
        return numeroDepartamento;
    }

    public void setNumeroDepartamento(Integer numeroDepartamento) {
        this.numeroDepartamento = numeroDepartamento;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public Integer getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(Integer cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public Integer getCantidadHuespedes() {
        return cantidadHuespedes;
    }

    public void setCantidadHuespedes(Integer cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }

    public Integer getCantidadBanios() {
        return cantidadBanios;
    }

    public void setCantidadBanios(Integer cantidadBanios) {
        this.cantidadBanios = cantidadBanios;
    }

    public Date getFechaConstruccion() {
        return fechaConstruccion;
    }

    public void setFechaConstruccion(Date fechaConstruccion) {
        this.fechaConstruccion = fechaConstruccion;
    }

    public Integer getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(Integer metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public Integer getValorArriendo() {
        return valorArriendo;
    }

    public void setValorArriendo(Integer valorArriendo) {
        this.valorArriendo = valorArriendo;
    }

    public Integer getValorizacion() {
        return valorizacion;
    }

    public void setValorizacion(Integer valorizacion) {
        this.valorizacion = valorizacion;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getDescripcionArriendo() {
        return descripcionArriendo;
    }

    public void setDescripcionArriendo(String descripcionArriendo) {
        this.descripcionArriendo = descripcionArriendo;
    }

    public String getPoliticaArriendo() {
        return politicaArriendo;
    }

    public void setPoliticaArriendo(String politicaArriendo) {
        this.politicaArriendo = politicaArriendo;
    }

    public String getInfCompl() {
        return infCompl;
    }

    public void setInfCompl(String infCompl) {
        this.infCompl = infCompl;
    }

    public EstadoDepartamento getEstadoDep() {
        return estadoDep;
    }

    public void setEstadoDep(EstadoDepartamento estadoDep) {
        this.estadoDep = estadoDep;
    }

    public Date getFechaRegisto() {
        return fechaRegisto;
    }

    public void setFechaRegisto(Date fechaRegisto) {
        this.fechaRegisto = fechaRegisto;
    }

    public Integer getUsado() {
        return usado;
    }

    public void setUsado(Integer usado) {
        this.usado = usado;
    }
    
	public List<FotosDepartamento> getFotos() {
		return fotos;
	}

	public void setFotos(List<FotosDepartamento> fotos) {
		this.fotos = fotos;
	}
	
	public List<InventarioDepartamento> getInventarios() {
		return inventarios;
	}

	public void setInventarios(List<InventarioDepartamento> inventarios) {
		this.inventarios = inventarios;
	}
	
	public List<DetallePrestacion> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(List<DetallePrestacion> prestaciones) {
		this.prestaciones = prestaciones;
	}
	/*
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	*/
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	/*
	public Integer[] listaHuespedes() {
		Integer[] lista = null;
		
		for (Integer i = 0; i < getCantidadHuespedes(); i++) {
			lista[i] = i;
		}
		
		return lista;
	}
	*/
	
	private static final long serialVersionUID = 1L;
}
