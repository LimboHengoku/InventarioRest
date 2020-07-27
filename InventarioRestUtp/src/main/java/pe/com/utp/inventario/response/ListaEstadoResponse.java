package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.bean.EstadoBean;

public class ListaEstadoResponse extends GenericoResponse{
	private List<EstadoBean> estados;

	public List<EstadoBean> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadoBean> estados) {
		this.estados = estados;
	}

}
