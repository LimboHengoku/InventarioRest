package pe.com.utp.inventario.response;

import pe.com.utp.inventario.bean.DispositivoBean;

public class DetalleDispositivoResponse extends GenericoResponse {

	private DispositivoBean dispositivo;

	public DispositivoBean getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoBean dispositivo) {
		this.dispositivo = dispositivo;
	}

}
