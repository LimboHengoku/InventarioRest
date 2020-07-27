package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class TipoImpresoraBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idTipoimpresora;
	private String nomTipoimpresora;
	private List<DispositivoUsuarioBean> dispositivoUsuarioBeans = new ArrayList<>();

	public Integer getIdTipoimpresora() {
		return idTipoimpresora;
	}

	public void setIdTipoimpresora(Integer idTipoimpresora) {
		this.idTipoimpresora = idTipoimpresora;
	}

	public String getNomTipoimpresora() {
		return nomTipoimpresora;
	}

	public void setNomTipoimpresora(String nomTipoimpresora) {
		this.nomTipoimpresora = nomTipoimpresora;
	}

	public List<DispositivoUsuarioBean> getDispositivoUsuarioBeans() {
		return dispositivoUsuarioBeans;
	}

	public void setDispositivoUsuarioBeans(List<DispositivoUsuarioBean> dispositivoUsuarioBeans) {
		this.dispositivoUsuarioBeans = dispositivoUsuarioBeans;
	}

}
