package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.bean.DivisionBean;
import pe.com.utp.inventario.bean.OficinaBean;
import pe.com.utp.inventario.bean.SedeBean;
import pe.com.utp.inventario.bean.UbicacionBean;

public class ListarUbicacionesResponse extends GenericoResponse {

	private List<SedeBean> sedes;
	private List<DivisionBean> divisiones;
	private List<OficinaBean> oficinas;

	public List<SedeBean> getSedes() {
		return sedes;
	}

	public void setSedes(List<SedeBean> sedes) {
		this.sedes = sedes;
	}

	public List<DivisionBean> getDivisiones() {
		return divisiones;
	}

	public void setDivisiones(List<DivisionBean> divisiones) {
		this.divisiones = divisiones;
	}

	public List<OficinaBean> getOficinas() {
		return oficinas;
	}

	public void setOficinas(List<OficinaBean> oficinas) {
		this.oficinas = oficinas;
	}

}
