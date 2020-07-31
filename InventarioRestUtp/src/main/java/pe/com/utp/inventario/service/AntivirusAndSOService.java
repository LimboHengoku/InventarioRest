package pe.com.utp.inventario.service;

import pe.com.utp.inventario.request.RegistrarAntivirusAndSORequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaAntivirusAndSOResponse;
import pe.com.utp.inventario.response.RegistrarAntivirusAndSOResponse;

public interface AntivirusAndSOService {
	
	public ListaAntivirusAndSOResponse listarAntivirusAndSO(String idTrans);
	public RegistrarAntivirusAndSOResponse registrarAntivirusAndSO(String idTrans,RegistrarAntivirusAndSORequest req);
	public GenericoResponse actualizarAntivirusAndSO(String idTrans,RegistrarAntivirusAndSORequest req);
	
}
