package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class TipoLogueoBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idTipologueo;
	private String nomTipologueo;
	private List<LogueoBean> logueoBeans = new ArrayList<>();

	public Integer getIdTipologueo() {
		return idTipologueo;
	}

	public void setIdTipologueo(Integer idTipologueo) {
		this.idTipologueo = idTipologueo;
	}

	public String getNomTipologueo() {
		return nomTipologueo;
	}

	public void setNomTipologueo(String nomTipologueo) {
		this.nomTipologueo = nomTipologueo;
	}

	public List<LogueoBean> getLogueoBeans() {
		return logueoBeans;
	}

	public void setLogueoBeans(List<LogueoBean> logueoBeans) {
		this.logueoBeans = logueoBeans;
	}

}
