package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioUbicacionBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuUbi;
	private CondicionBean condicionBean;
	private DominioBean dominioBean;
	private UbicacionBean ubicacionBean;
	private UsuarioBean usuarioBean;
	private Date fecMod;
	private List<DispositivoUsuarioBean> dispositivoUsuarioBeans = new ArrayList<>();

	public Integer getIdUsuUbi() {
		return idUsuUbi;
	}

	public void setIdUsuUbi(Integer idUsuUbi) {
		this.idUsuUbi = idUsuUbi;
	}

	public CondicionBean getCondicionBean() {
		return condicionBean;
	}

	public void setCondicionBean(CondicionBean condicionBean) {
		this.condicionBean = condicionBean;
	}

	public DominioBean getDominioBean() {
		return dominioBean;
	}

	public void setDominioBean(DominioBean dominioBean) {
		this.dominioBean = dominioBean;
	}

	public UbicacionBean getUbicacionBean() {
		return ubicacionBean;
	}

	public void setUbicacionBean(UbicacionBean ubicacionBean) {
		this.ubicacionBean = ubicacionBean;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public List<DispositivoUsuarioBean> getDispositivoUsuarioBeans() {
		return dispositivoUsuarioBeans;
	}

	public void setDispositivoUsuarioBeans(List<DispositivoUsuarioBean> dispositivoUsuarioBeans) {
		this.dispositivoUsuarioBeans = dispositivoUsuarioBeans;
	}

}
