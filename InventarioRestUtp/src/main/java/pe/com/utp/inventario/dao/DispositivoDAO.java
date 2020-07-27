package pe.com.utp.inventario.dao;

import java.util.List;
import java.util.Map;

import pe.com.utp.inventario.entities.Dispositivo;
import pe.com.utp.inventario.entities.DispositivoUsuario;

public interface DispositivoDAO {

	public int cantidadDispositivosActivos(String idTrans);
	
	public List<Dispositivo> listaDispositivos(String idTrans,String nombreDispo);
	
	public Map<String, String> registrarDispositivo(String idTrans,Dispositivo d);
	
	public Map<String, String> actualizarDispositivo(String idTrans,Dispositivo d);
	
	public Map<String, Object> obtenerDetalleDispositivo(String idTrans,int idDispositivo);
	
	public List<DispositivoUsuario> obtenerDispositivoVinculado(String idTrans,
			int idUsuario);
	
}
