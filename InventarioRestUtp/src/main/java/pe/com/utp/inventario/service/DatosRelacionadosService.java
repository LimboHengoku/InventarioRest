package pe.com.utp.inventario.service;

import pe.com.utp.inventario.response.ListarAntivirusResponse;
import pe.com.utp.inventario.response.ListarProcesadoresResponse;

public interface DatosRelacionadosService {

	public ListarAntivirusResponse listarAntivirus();
	
	public ListarProcesadoresResponse listarProcesadores();
	
}
