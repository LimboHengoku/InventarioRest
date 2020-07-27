package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class CondicionBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idCondicion;
	private String nomCondicion;
	private List<CpuSoBean> cpuSoBeans = new ArrayList<>();
	private List<DispositivoIpBean> dispositivoIpBeans = new ArrayList<>();
	private List<RecursoDispositivoBean> recursoDispositivoBeans = new ArrayList<>();
	private List<DispositivoUsuarioBean> dispositivoUsuarioBeans = new ArrayList<>();
	private List<ServicioBean> servicioBeans = new ArrayList<>();
	private List<UsuarioUbicacionBean> usuarioUbicacionBeans = new ArrayList<>();

	public Integer getIdCondicion() {
		return idCondicion;
	}

	public void setIdCondicion(Integer idCondicion) {
		this.idCondicion = idCondicion;
	}

	public String getNomCondicion() {
		return nomCondicion;
	}

	public void setNomCondicion(String nomCondicion) {
		this.nomCondicion = nomCondicion;
	}

	public List<CpuSoBean> getCpuSoBeans() {
		return cpuSoBeans;
	}

	public void setCpuSoBeans(List<CpuSoBean> cpuSoBeans) {
		this.cpuSoBeans = cpuSoBeans;
	}

	public List<DispositivoIpBean> getDispositivoIpBeans() {
		return dispositivoIpBeans;
	}

	public void setDispositivoIpBeans(List<DispositivoIpBean> dispositivoIpBeans) {
		this.dispositivoIpBeans = dispositivoIpBeans;
	}

	public List<RecursoDispositivoBean> getRecursoDispositivoBeans() {
		return recursoDispositivoBeans;
	}

	public void setRecursoDispositivoBeans(List<RecursoDispositivoBean> recursoDispositivoBeans) {
		this.recursoDispositivoBeans = recursoDispositivoBeans;
	}

	public List<DispositivoUsuarioBean> getDispositivoUsuarioBeans() {
		return dispositivoUsuarioBeans;
	}

	public void setDispositivoUsuarioBeans(List<DispositivoUsuarioBean> dispositivoUsuarioBeans) {
		this.dispositivoUsuarioBeans = dispositivoUsuarioBeans;
	}

	public List<ServicioBean> getServicioBeans() {
		return servicioBeans;
	}

	public void setServicioBeans(List<ServicioBean> servicioBeans) {
		this.servicioBeans = servicioBeans;
	}

	public List<UsuarioUbicacionBean> getUsuarioUbicacionBeans() {
		return usuarioUbicacionBeans;
	}

	public void setUsuarioUbicacionBeans(List<UsuarioUbicacionBean> usuarioUbicacionBeans) {
		this.usuarioUbicacionBeans = usuarioUbicacionBeans;
	}

}
