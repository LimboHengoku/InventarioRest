package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class DominioBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idDominio;
	private String nomDominio;
	private List<UsuarioUbicacionBean> usuarioUbicacionBeans = new ArrayList<>();

	public Integer getIdDominio() {
		return idDominio;
	}

	public void setIdDominio(Integer idDominio) {
		this.idDominio = idDominio;
	}

	public String getNomDominio() {
		return nomDominio;
	}

	public void setNomDominio(String nomDominio) {
		this.nomDominio = nomDominio;
	}

	public List<UsuarioUbicacionBean> getUsuarioUbicacionBeans() {
		return usuarioUbicacionBeans;
	}

	public void setUsuarioUbicacionBeans(List<UsuarioUbicacionBean> usuarioUbicacionBeans) {
		this.usuarioUbicacionBeans = usuarioUbicacionBeans;
	}

}
