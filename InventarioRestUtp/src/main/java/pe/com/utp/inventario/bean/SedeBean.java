package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class SedeBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idSede;
	private String nomSede;
	private List<UbicacionBean> ubicacionBeans = new ArrayList<>();

	public Integer getIdSede() {
		return idSede;
	}

	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}

	public String getNomSede() {
		return nomSede;
	}

	public void setNomSede(String nomSede) {
		this.nomSede = nomSede;
	}

	public List<UbicacionBean> getUbicacionBeans() {
		return ubicacionBeans;
	}

	public void setUbicacionBeans(List<UbicacionBean> ubicacionBeans) {
		this.ubicacionBeans = ubicacionBeans;
	}

}
