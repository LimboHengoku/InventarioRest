package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.bean.CpuBean;

public class ListarProcesadoresResponse extends GenericoResponse {

	private List<CpuBean> procesadores;

	public List<CpuBean> getProcesadores() {
		return procesadores;
	}

	public void setProcesadores(List<CpuBean> procesadores) {
		this.procesadores = procesadores;
	}

}
