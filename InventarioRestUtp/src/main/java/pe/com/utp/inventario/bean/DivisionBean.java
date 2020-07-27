package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class DivisionBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idDivision;
	private String nomDivision;
	private List<UbicacionBean> ubicacionBeans = new ArrayList<UbicacionBean>();

	public Integer getIdDivision() {
		return idDivision;
	}

	public void setIdDivision(Integer idDivision) {
		this.idDivision = idDivision;
	}

	public String getNomDivision() {
		return nomDivision;
	}

	public void setNomDivision(String nomDivision) {
		this.nomDivision = nomDivision;
	}

	public List<UbicacionBean> getUbicacionBeans() {
		return ubicacionBeans;
	}

	public void setUbicacionBeans(List<UbicacionBean> ubicacionBeans) {
		this.ubicacionBeans = ubicacionBeans;
	}

}
