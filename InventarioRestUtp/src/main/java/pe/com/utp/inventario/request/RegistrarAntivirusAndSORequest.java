package pe.com.utp.inventario.request;

import pe.com.utp.inventario.mapper.AntivirusAndSOMapper;

public class RegistrarAntivirusAndSORequest {

	private String flag;
	private AntivirusAndSOMapper recurso;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public AntivirusAndSOMapper getRecurso() {
		return recurso;
	}

	public void setRecurso(AntivirusAndSOMapper recurso) {
		this.recurso = recurso;
	}

}
