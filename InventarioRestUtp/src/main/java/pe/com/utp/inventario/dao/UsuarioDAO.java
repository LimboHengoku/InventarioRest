package pe.com.utp.inventario.dao;

import java.util.Map;

import pe.com.utp.inventario.entities.Logueo;
import pe.com.utp.inventario.entities.Usuario;
import pe.com.utp.inventario.entities.UsuarioUbicacion;
//import pe.com.utp.inventario.entities.Logueo;
import pe.com.utp.inventario.response.ListaUsuarioResponse;

public interface UsuarioDAO {
	
	public ListaUsuarioResponse listarUsuarios();
	
	public Logueo login(String idTransaccion,
			String usuario,String clave);
	
	public Map<String,String> registrarUsuario(
			String idTransaccion, Usuario u );
	
	public Map<String,String> actualizarUsuario(
			String idTransaccion, Usuario u );
	
	public Map<String,String> registrarUbicacionUsuario(
			String idTransaccion, Map<String, String> params);

}