package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class OficinaBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idOficina;
	private String nomOficina;
	private List<UbicacionBean> ubicacionBeans = new ArrayList<>();

	public Integer getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(Integer idOficina) {
		this.idOficina = idOficina;
	}

	public String getNomOficina() {
		return nomOficina;
	}

	public void setNomOficina(String nomOficina) {
		this.nomOficina = nomOficina;
	}

	public List<UbicacionBean> getUbicacionBeans() {
		return ubicacionBeans;
	}

	public void setUbicacionBeans(List<UbicacionBean> ubicacionBeans) {
		this.ubicacionBeans = ubicacionBeans;
	}

}
