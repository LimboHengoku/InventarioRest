package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class EstadoBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idEstado;
	private String nomEstado;
	private List<RecursoBean> recursoBeans = new ArrayList<RecursoBean>();
	private List<DispositivoBean> dispositivoBeans = new ArrayList<DispositivoBean>();

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomEstado() {
		return nomEstado;
	}

	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}

	public List<RecursoBean> getRecursoBeans() {
		return recursoBeans;
	}

	public void setRecursoBeans(List<RecursoBean> recursoBeans) {
		this.recursoBeans = recursoBeans;
	}

	public List<DispositivoBean> getDispositivoBeans() {
		return dispositivoBeans;
	}

	public void setDispositivoBeans(List<DispositivoBean> dispositivoBeans) {
		this.dispositivoBeans = dispositivoBeans;
	}

}
