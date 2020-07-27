package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.bean.ProveedorBean;

public class ListaProveedorResponse extends GenericoResponse {

	private List<ProveedorBean> proveedores;

	public List<ProveedorBean> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<ProveedorBean> proveedores) {
		this.proveedores = proveedores;
	}

}
