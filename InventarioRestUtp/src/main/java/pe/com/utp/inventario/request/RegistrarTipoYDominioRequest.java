package pe.com.utp.inventario.request;

import pe.com.utp.inventario.mapper.TipoYDominioMapper;

public class RegistrarTipoYDominioRequest {

	private String flag;
	private TipoYDominioMapper tipoDominio;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public TipoYDominioMapper getTipoDominio() {
		return tipoDominio;
	}

	public void setTipoDominio(TipoYDominioMapper tipoDominio) {
		this.tipoDominio = tipoDominio;
	}

}
