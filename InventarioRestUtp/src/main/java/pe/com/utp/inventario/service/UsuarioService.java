package pe.com.utp.inventario.service;

import pe.com.utp.inventario.request.LoginRequest;
import pe.com.utp.inventario.request.NuevoUsuarioRequest;
import pe.com.utp.inventario.request.RegistrarUsuarioRequest;
import pe.com.utp.inventario.request.RegistrarUsuarioUbicacionRequest;
import pe.com.utp.inventario.response.ListaRolResponse;
import pe.com.utp.inventario.response.ListaUsuarioResponse;
import pe.com.utp.inventario.response.LoginResponse;
import pe.com.utp.inventario.response.RegistrarUsuarioResponse;
import pe.com.utp.inventario.response.RegistrarUsuarioUbicacionResponse;

public interface UsuarioService {

	public ListaUsuarioResponse listarUsuarios();
	
	public LoginResponse login (String idTrans,
			LoginRequest request);
	
	public ListaRolResponse listarRoles(String idTrans);
	
	public RegistrarUsuarioResponse registrarUsuario(String idTrans,
			RegistrarUsuarioRequest request);
	
	public RegistrarUsuarioResponse registrarUsuarioV2(String idTrans,
			NuevoUsuarioRequest request);
	
	public RegistrarUsuarioUbicacionResponse registrarUsuarioUbicacion(String idTrans,
			RegistrarUsuarioUbicacionRequest request); 
}
