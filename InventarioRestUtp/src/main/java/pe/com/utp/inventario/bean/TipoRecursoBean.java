package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class TipoRecursoBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idTiporecurso;
	private String nomTiporecurso;
	private List<RecursoBean> recursoBeans = new ArrayList<>();

	public Integer getIdTiporecurso() {
		return idTiporecurso;
	}

	public void setIdTiporecurso(Integer idTiporecurso) {
		this.idTiporecurso = idTiporecurso;
	}

	public String getNomTiporecurso() {
		return nomTiporecurso;
	}

	public void setNomTiporecurso(String nomTiporecurso) {
		this.nomTiporecurso = nomTiporecurso;
	}

	public List<RecursoBean> getRecursoBeans() {
		return recursoBeans;
	}

	public void setRecursoBeans(List<RecursoBean> recursoBeans) {
		this.recursoBeans = recursoBeans;
	}

}
