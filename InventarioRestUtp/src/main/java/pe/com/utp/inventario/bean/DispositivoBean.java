package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispositivoBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idDispositivo;
	private EstadoBean estadoBean;
	private TipoDispositivoBean tipoDispositivoBean;
	private UbicacionBean ubicacionBean;
	private String marca;
	private String codBarras;
	private String modelo;
	private String serie;
	private String observacion;
	private Integer idDispasoc;
	private Date fecMod;
	private List<RecursoDispositivoBean> recursoDispositivoBeans = new ArrayList<>();
	private CpuBean cpuBean;
	private List<DispositivoUsuarioBean> dispositivoUsuarioBeans = new ArrayList<>();
	private Date fecReg;
	private String urlImagen;

	public Integer getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(Integer idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public EstadoBean getEstadoBean() {
		return estadoBean;
	}

	public void setEstadoBean(EstadoBean estadoBean) {
		this.estadoBean = estadoBean;
	}

	public TipoDispositivoBean getTipoDispositivoBean() {
		return tipoDispositivoBean;
	}

	public void setTipoDispositivoBean(TipoDispositivoBean tipoDispositivoBean) {
		this.tipoDispositivoBean = tipoDispositivoBean;
	}

	public UbicacionBean getUbicacionBean() {
		return ubicacionBean;
	}

	public void setUbicacionBean(UbicacionBean ubicacionBean) {
		this.ubicacionBean = ubicacionBean;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getIdDispasoc() {
		return idDispasoc;
	}

	public void setIdDispasoc(Integer idDispasoc) {
		this.idDispasoc = idDispasoc;
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

	public CpuBean getCpuBean() {
		return cpuBean;
	}

	public void setCpuBean(CpuBean cpuBean) {
		this.cpuBean = cpuBean;
	}

	public List<DispositivoUsuarioBean> getDispositivoUsuarioBeans() {
		return dispositivoUsuarioBeans;
	}

	public void setDispositivoUsuarioBeans(List<DispositivoUsuarioBean> dispositivoUsuarioBeans) {
		this.dispositivoUsuarioBeans = dispositivoUsuarioBeans;
	}

	public Date getFecReg() {
		return fecReg;
	}

	public void setFecReg(Date fecReg) {
		this.fecReg = fecReg;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

}
