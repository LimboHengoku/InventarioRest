package pe.com.utp.inventario.service;

import pe.com.utp.inventario.response.ListaEstadoResponse;

public interface EstadosService {

	public ListaEstadoResponse listarEstados(String idTrans);
}
