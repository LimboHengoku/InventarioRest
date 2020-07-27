package pe.com.utp.inventario.service;

import pe.com.utp.inventario.request.RegistrarTipoYDominioRequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaTipoYDominioResponse;

public interface TipoYDominioService {
	public ListaTipoYDominioResponse listaTipoYdominio(String idTrans);
	public GenericoResponse registrarTipoYDominio(String idTraString,RegistrarTipoYDominioRequest req);
}
