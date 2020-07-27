package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.bean.TipoLogueoBean;

public class ListaRolResponse extends GenericoResponse {

	private List<TipoLogueoBean> roles;

	public List<TipoLogueoBean> getRoles() {
		return roles;
	}

	public void setRoles(List<TipoLogueoBean> roles) {
		this.roles = roles;
	}

}
