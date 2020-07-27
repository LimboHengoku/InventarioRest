package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.mapper.TipoYDominioMapper;

public class ListaTipoYDominioResponse extends GenericoResponse {

	private List<TipoYDominioMapper> listaTipoYDominio;

	public List<TipoYDominioMapper> getListaTipoYDominio() {
		return listaTipoYDominio;
	}

	public void setListaTipoYDominio(List<TipoYDominioMapper> listaTipoYDominio) {
		this.listaTipoYDominio = listaTipoYDominio;
	}

}
