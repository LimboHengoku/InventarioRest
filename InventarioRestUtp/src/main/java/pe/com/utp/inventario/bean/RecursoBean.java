package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecursoBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idRecurso;
	private EstadoBean estadoBean;
	private TipoRecursoBean tipoRecursoBean;
	private String serie;
	private String marca;
	private String modelo;
	private String capacidad;
	private String observacion;
	private Date fecMod;
	private List<RecursoDispositivoBean> recursoDispositivoBeans = new ArrayList<>();

	public Integer getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
	}

	public EstadoBean getEstadoBean() {
		return estadoBean;
	}

	public void setEstadoBean(EstadoBean estadoBean) {
		this.estadoBean = estadoBean;
	}

	public TipoRecursoBean getTipoRecursoBean() {
		return tipoRecursoBean;
	}

	public void setTipoRecursoBean(TipoRecursoBean tipoRecursoBean) {
		this.tipoRecursoBean = tipoRecursoBean;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public List<RecursoDispositivoBean> getRecursoDispositivoBeans() {
		return recursoDispositivoBeans;
	}

	public void setRecursoDispositivoBeans(List<RecursoDispositivoBean> recursoDispositivoBeans) {
		this.recursoDispositivoBeans = recursoDispositivoBeans;
	}

}
