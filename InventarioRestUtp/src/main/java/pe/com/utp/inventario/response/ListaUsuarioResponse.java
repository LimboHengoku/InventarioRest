package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.bean.UsuarioBean;

public class ListaUsuarioResponse extends GenericoResponse{

	private List<UsuarioBean> usuarios;

	public List<UsuarioBean> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}

}
