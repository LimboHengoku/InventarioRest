package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.mapper.AntivirusAndSOMapper;

public class ListaAntivirusAndSOResponse extends GenericoResponse {

	private List<AntivirusAndSOMapper> recursos;

	public List<AntivirusAndSOMapper> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<AntivirusAndSOMapper> recursos) {
		this.recursos = recursos;
	}

}
