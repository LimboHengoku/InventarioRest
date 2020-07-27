package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class DispositivoUsuarioBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idDisUsu;
	private CondicionBean condicionBean;
	private DispositivoBean dispositivoBean;
	private TipoImpresoraBean tipoImpresoraBean;
	private UsuarioUbicacionBean usuarioUbicacionBean;
	private Date fecMod;
	private String observacion;

	public Integer getIdDisUsu() {
		return idDisUsu;
	}

	public void setIdDisUsu(Integer idDisUsu) {
		this.idDisUsu = idDisUsu;
	}

	public CondicionBean getCondicionBean() {
		return condicionBean;
	}

	public void setCondicionBean(CondicionBean condicionBean) {
		this.condicionBean = condicionBean;
	}

	public DispositivoBean getDispositivoBean() {
		return dispositivoBean;
	}

	public void setDispositivoBean(DispositivoBean dispositivoBean) {
		this.dispositivoBean = dispositivoBean;
	}

	public TipoImpresoraBean getTipoImpresoraBean() {
		return tipoImpresoraBean;
	}

	public void setTipoImpresoraBean(TipoImpresoraBean tipoImpresoraBean) {
		this.tipoImpresoraBean = tipoImpresoraBean;
	}

	public UsuarioUbicacionBean getUsuarioUbicacionBean() {
		return usuarioUbicacionBean;
	}

	public void setUsuarioUbicacionBean(UsuarioUbicacionBean usuarioUbicacionBean) {
		this.usuarioUbicacionBean = usuarioUbicacionBean;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
