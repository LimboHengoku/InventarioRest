package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class TipoLicenciaBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idTipolicencia;
	private String nomTipolicencia;
	private List<ServicioBean> servicioBeans = new ArrayList<>();

	public Integer getIdTipolicencia() {
		return idTipolicencia;
	}

	public void setIdTipolicencia(Integer idTipolicencia) {
		this.idTipolicencia = idTipolicencia;
	}

	public String getNomTipolicencia() {
		return nomTipolicencia;
	}

	public void setNomTipolicencia(String nomTipolicencia) {
		this.nomTipolicencia = nomTipolicencia;
	}

	public List<ServicioBean> getServicioBeans() {
		return servicioBeans;
	}

	public void setServicioBeans(List<ServicioBean> servicioBeans) {
		this.servicioBeans = servicioBeans;
	}

}
