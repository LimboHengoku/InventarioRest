package pe.com.utp.inventario.request;

import pe.com.utp.inventario.bean.UsuarioBean;

public class NuevoUsuarioRequest {

	private UsuarioBean usuario;
	private String flag;

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
