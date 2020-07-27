package pe.com.utp.inventario.request;

import pe.com.utp.inventario.bean.DispositivoBean;

public class RegistrarDispositivoRequest {
	private DispositivoBean dispositivo;

	public DispositivoBean getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoBean dispositivo) {
		this.dispositivo = dispositivo;
	}

}
