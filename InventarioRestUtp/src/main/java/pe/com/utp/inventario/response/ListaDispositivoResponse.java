package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.bean.DispositivoBean;

public class ListaDispositivoResponse extends GenericoResponse {

	private List<DispositivoBean> dispositivos;

	public List<DispositivoBean> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<DispositivoBean> dispositivos) {
		this.dispositivos = dispositivos;
	}

}
