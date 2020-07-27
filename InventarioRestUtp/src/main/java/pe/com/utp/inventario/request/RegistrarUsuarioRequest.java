package pe.com.utp.inventario.request;

import pe.com.utp.inventario.mapper.UsuarioMapper;

public class RegistrarUsuarioRequest {

	private UsuarioMapper usuario;

	public UsuarioMapper getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioMapper usuario) {
		this.usuario = usuario;
	}

}
