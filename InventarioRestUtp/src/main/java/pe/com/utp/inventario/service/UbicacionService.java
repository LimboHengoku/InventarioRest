package pe.com.utp.inventario.service;
 
import pe.com.utp.inventario.request.RegistrarUbicacionRequest; 
import pe.com.utp.inventario.response.ListarUbicacionesResponse;
import pe.com.utp.inventario.response.RegistrarUbicacionResponse;

public interface UbicacionService {
	public ListarUbicacionesResponse listarUbicacion(String idTransaccion);
	
	public RegistrarUbicacionResponse generarIdUbicacion(String idTransaccion, 
			RegistrarUbicacionRequest req);

}
