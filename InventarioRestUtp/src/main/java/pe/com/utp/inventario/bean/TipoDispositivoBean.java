package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TipoDispositivoBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idTipodispositivo;
	private String nomDispositivo;
	private Date fechaRegistro;
	private List<DispositivoBean> dispositivoBeans = new ArrayList<>();

	public Integer getIdTipodispositivo() {
		return idTipodispositivo;
	}

	public void setIdTipodispositivo(Integer idTipodispositivo) {
		this.idTipodispositivo = idTipodispositivo;
	}

	public String getNomDispositivo() {
		return nomDispositivo;
	}

	public void setNomDispositivo(String nomDispositivo) {
		this.nomDispositivo = nomDispositivo;
	}

	public List<DispositivoBean> getDispositivoBeans() {
		return dispositivoBeans;
	}

	public void setDispositivoBeans(List<DispositivoBean> dispositivoBeans) {
		this.dispositivoBeans = dispositivoBeans;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
