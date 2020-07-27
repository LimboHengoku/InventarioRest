package pe.com.utp.inventario.service;

import pe.com.utp.inventario.request.DetalleDispositivoRequest;
import pe.com.utp.inventario.request.ListaDispositivoRequest;
import pe.com.utp.inventario.request.RegistrarDispositivoRequest;
import pe.com.utp.inventario.response.DetalleDispositivoResponse;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaDispositivoResponse;

public interface DispositivoService {

	public int cantidadDispositivosActivos(String idTrans);
	
	public ListaDispositivoResponse listarDispositivos(String idTrans,
			ListaDispositivoRequest params);
	
	public GenericoResponse registrarDispositivo(String idTrans,
			RegistrarDispositivoRequest params);
	
	public GenericoResponse actualizarDispositivo(String idTrans,
			RegistrarDispositivoRequest params);
	
	public DetalleDispositivoResponse obtenerDetalleDispositivo(String idTrans,
			DetalleDispositivoRequest params);
	
}
