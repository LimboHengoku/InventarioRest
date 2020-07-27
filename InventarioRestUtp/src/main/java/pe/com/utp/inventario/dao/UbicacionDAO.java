package pe.com.utp.inventario.dao;

import java.util.List;
import java.util.Map;

import pe.com.utp.inventario.entities.Division;
import pe.com.utp.inventario.entities.Oficina;
import pe.com.utp.inventario.entities.Sede;
import pe.com.utp.inventario.entities.Ubicacion;

public interface UbicacionDAO {

	
	public List<Ubicacion> listaUbicacion(String idTransaccion);
	public List<Sede> listarSedes(String idTransaccion);
	public List<Division> listarDivision(String idTransaccion);
	public List<Oficina> listarOficinas(String idTransaccion);
	public Map<String,String> registrarUbicacion(String idTransaccion,Ubicacion u);
}
