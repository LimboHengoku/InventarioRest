package pe.com.utp.inventario.dao;

import java.util.List;
import java.util.Map;

import pe.com.utp.inventario.entities.Proveedor; 

public interface ProveedorDAO {
	
	public List<Proveedor> listarProveedor(String idTrans,
			String nombreProveedor);
	
	public Map<String, String> registrarNuevoProveedor(String idTrans,
			Proveedor p);
	
	public Map<String, String> actualizarNuevoProveedor(String idTrans,
			Proveedor p);
	

}
