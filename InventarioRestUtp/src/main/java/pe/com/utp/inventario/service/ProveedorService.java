package pe.com.utp.inventario.service;

import pe.com.utp.inventario.request.ListaProveedorRequest;
import pe.com.utp.inventario.request.RegistrarProveedorRequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaProveedorResponse;

public interface ProveedorService {
	
	public ListaProveedorResponse listarProveedores(String idTrans,
			ListaProveedorRequest req);
	
	public GenericoResponse registrarProveedor(String idTrans,
			RegistrarProveedorRequest req);
	
	public GenericoResponse actualizarrProveedor(String idTrans,
			RegistrarProveedorRequest req);

}
