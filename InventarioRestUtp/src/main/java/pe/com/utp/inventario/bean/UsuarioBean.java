package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuario;
	private String nombres;
	private String ape1;
	private String ape2;
	private String usuRed;
	private Date fecMod;
	private List<LogueoBean> logueoBeans = new ArrayList<>();
	private List<UsuarioUbicacionBean> usuarioUbicacionBeans = new ArrayList<UsuarioUbicacionBean>();
	private String estado;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getUsuRed() {
		return usuRed;
	}

	public void setUsuRed(String usuRed) {
		this.usuRed = usuRed;
	}

	public List<LogueoBean> getLogueoBeans() {
		return logueoBeans;
	}

	public void setLogueoBeans(List<LogueoBean> logueoBeans) {
		this.logueoBeans = logueoBeans;
	}

	public List<UsuarioUbicacionBean> getUsuarioUbicacionBeans() {
		return usuarioUbicacionBeans;
	}

	public void setUsuarioUbicacionBeans(List<UsuarioUbicacionBean> usuarioUbicacionBeans) {
		this.usuarioUbicacionBeans = usuarioUbicacionBeans;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
