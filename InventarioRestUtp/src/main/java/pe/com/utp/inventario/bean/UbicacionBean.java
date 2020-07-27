package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class UbicacionBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUbicacion;
	private DivisionBean divisionBean;
	private OficinaBean oficinaBean;
	private SedeBean sedeBean;
	private List<DispositivoBean> dispositivoBeans = new ArrayList<>();
	private List<UsuarioUbicacionBean> usuarioUbicacionBeans = new ArrayList<>();
	private List<ServicioBean> servicioBeans = new ArrayList<>();

	public Integer getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(Integer idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public DivisionBean getDivisionBean() {
		return divisionBean;
	}

	public void setDivisionBean(DivisionBean divisionBean) {
		this.divisionBean = divisionBean;
	}

	public OficinaBean getOficinaBean() {
		return oficinaBean;
	}

	public void setOficinaBean(OficinaBean oficinaBean) {
		this.oficinaBean = oficinaBean;
	}

	public SedeBean getSedeBean() {
		return sedeBean;
	}

	public void setSedeBean(SedeBean sedeBean) {
		this.sedeBean = sedeBean;
	}

	public List<DispositivoBean> getDispositivoBeans() {
		return dispositivoBeans;
	}

	public void setDispositivoBeans(List<DispositivoBean> dispositivoBeans) {
		this.dispositivoBeans = dispositivoBeans;
	}

	public List<UsuarioUbicacionBean> getUsuarioUbicacionBeans() {
		return usuarioUbicacionBeans;
	}

	public void setUsuarioUbicacionBeans(List<UsuarioUbicacionBean> usuarioUbicacionBeans) {
		this.usuarioUbicacionBeans = usuarioUbicacionBeans;
	}

	public List<ServicioBean> getServicioBeans() {
		return servicioBeans;
	}

	public void setServicioBeans(List<ServicioBean> servicioBeans) {
		this.servicioBeans = servicioBeans;
	}

}
