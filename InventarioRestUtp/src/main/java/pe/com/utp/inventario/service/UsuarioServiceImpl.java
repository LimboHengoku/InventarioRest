package pe.com.utp.inventario.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.utp.inventario.bean.LogueoBean;
import pe.com.utp.inventario.bean.TipoLogueoBean;
import pe.com.utp.inventario.bean.UsuarioBean;
import pe.com.utp.inventario.dao.RolDAO;
import pe.com.utp.inventario.dao.UbicacionDAO;
import pe.com.utp.inventario.dao.UsuarioDAO;
import pe.com.utp.inventario.entities.Division;
import pe.com.utp.inventario.entities.Logueo;
import pe.com.utp.inventario.entities.Oficina;
import pe.com.utp.inventario.entities.Sede;
import pe.com.utp.inventario.entities.TipoLogueo;
import pe.com.utp.inventario.entities.Ubicacion;
import pe.com.utp.inventario.entities.Usuario;
import pe.com.utp.inventario.request.LoginRequest;
import pe.com.utp.inventario.request.NuevoUsuarioRequest;
import pe.com.utp.inventario.request.RegistrarUsuarioRequest;
import pe.com.utp.inventario.request.RegistrarUsuarioUbicacionRequest;
import pe.com.utp.inventario.response.ListaRolResponse;
import pe.com.utp.inventario.response.ListaUsuarioResponse;
import pe.com.utp.inventario.response.LoginResponse;
import pe.com.utp.inventario.response.RegistrarUsuarioResponse;
import pe.com.utp.inventario.response.RegistrarUsuarioUbicacionResponse;
import pe.com.utp.inventario.util.Constantes;

@Service(value = "usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private RolDAO rolDAO;

	@Autowired
	private UbicacionDAO ubicacionDAO;

	@Override
	public ListaUsuarioResponse listarUsuarios() {
		return usuarioDAO.listarUsuarios();
	}

	@Override
	public LoginResponse login(String idTrans, LoginRequest request) {

		LoginResponse response = new LoginResponse();

		LogueoBean loginBean = new LogueoBean();

		try {

			Logueo login = usuarioDAO.login(idTrans, request.getNombreUsuario(), request.getClave());

			if (login != null) {

				TipoLogueoBean tipoLogeo = new TipoLogueoBean();
				UsuarioBean usuarioBean = new UsuarioBean();

				TipoLogueo tipoLog = login.getTipoLogueo();
				Usuario u = login.getUsuario();

				loginBean.setIdLogueo(login.getIdLogueo());
				loginBean.setUser(login.getUser());
				loginBean.setPass(login.getPass());

				tipoLogeo.setIdTipologueo(tipoLog.getIdTipologueo());
				tipoLogeo.setNomTipologueo(tipoLog.getNomTipologueo());

				usuarioBean.setIdUsuario(u.getIdUsuario());
				usuarioBean.setNombres(u.getNombres());
				usuarioBean.setApe1(u.getApe1());
				usuarioBean.setApe2(u.getApe2());
				usuarioBean.setUsuRed(u.getUsuRed());

				loginBean.setTipoLogueoBean(tipoLogeo);
				loginBean.setUsuarioBean(usuarioBean);
				loginBean.setSesiones(login.getSesiones());

				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);

			} else {
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_USUARIO_NO_ENCONTRADO);
				response.setMensajeRespuesta(Constantes.MENSAJE_USUARIO_NO_ENCONTRADO);
			}

			response.setLogin(loginBean);

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta(e.getMessage() + " : " + e);
		}

		return response;
	}

	@Override
	public ListaRolResponse listarRoles(String idTrans) {

		ListaRolResponse response = new ListaRolResponse();

		List<TipoLogueoBean> lista = new ArrayList<>();

		try {

			List<TipoLogueo> result = rolDAO.listarRoles(idTrans);

			if (!result.isEmpty()) {

				for (TipoLogueo r : result) {
					TipoLogueoBean bean = new TipoLogueoBean();
					bean.setIdTipologueo(r.getIdTipologueo());
					bean.setNomTipologueo(r.getNomTipologueo());
					lista.add(bean);
				}

			} else {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_NOEXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_NOEXITOSO);
			}

			response.setRoles(lista);

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta(e.getMessage() + " : " + e);
		}

		return response;
	}

	@Override
	public RegistrarUsuarioResponse registrarUsuario(String idTrans, RegistrarUsuarioRequest request) {

		RegistrarUsuarioResponse response = new RegistrarUsuarioResponse();

		try {

			Ubicacion ub = new Ubicacion();
			Division division = new Division();
			Oficina oficina = new Oficina();
			Sede sede = new Sede();

			division.setIdDivision(request.getUsuario().getIdDivision());
			oficina.setIdOficina(request.getUsuario().getIdOficina());
			sede.setIdSede(request.getUsuario().getIdSede());

			ub.setDivision(division);
			ub.setSede(sede);
			ub.setOficina(oficina);

			Usuario u = new Usuario();

			if (request.getUsuario().getIdUsuario() != 0) {
				u.setIdUsuario(request.getUsuario().getIdUsuario());
			}

			u.setApe1(request.getUsuario().getApe1());
			u.setApe2(request.getUsuario().getApe2());
			u.setNombres(request.getUsuario().getNombres());
			u.setUsuRed(request.getUsuario().getUsuRed());
			u.setFecMod(new Date());

			Map<String, String> resultUsuario = usuarioDAO.registrarUsuario(idTrans, u);

			if (resultUsuario.get(Constantes.CODIGO_RESPUESTA).toString().equals(Constantes.CODIGO_OK)) {

				Map<String, String> resultUbicacion = ubicacionDAO.registrarUbicacion(idTrans, ub);

				System.out.println("resultUbicacion.get(Constantes.CODIGO_RESPUESTA).toString() "
						+ resultUbicacion.get(Constantes.CODIGO_RESPUESTA).toString());

				System.out.println("resultUbicacion.get(Constantes.MENSAJE_RESPUESTA).toString() "
						+ resultUbicacion.get(Constantes.MENSAJE_RESPUESTA).toString());

				System.out.println("resultUbicacion.get(Constantes.CODIGO_GENERADO).toString() "
						+ resultUbicacion.get(Constantes.CODIGO_GENERADO).toString());

				if (resultUbicacion.get(Constantes.CODIGO_RESPUESTA).toString().equals(Constantes.CODIGO_OK)) {

					Map<String, String> params = new HashMap<>();
					params.put(Constantes.ID_CONDICION, String
							.valueOf(request.getUsuario().getUsuarioUbicacion().getCondicionBean().getIdCondicion()));
					params.put(Constantes.ID_DOMINIO,
							String.valueOf(request.getUsuario().getUsuarioUbicacion().getDominioBean().getIdDominio()));
					params.put(Constantes.ID_UBICACION,
							String.valueOf(resultUbicacion.get(Constantes.CODIGO_GENERADO).toString()));
					params.put(Constantes.ID_USUARIO,
							String.valueOf(resultUsuario.get(Constantes.CODIGO_GENERADO).toString()));

					System.out.println(params.get(Constantes.ID_CONDICION).toString());
					System.out.println(params.get(Constantes.ID_DOMINIO).toString());
					System.out.println(params.get(Constantes.ID_UBICACION).toString());
					System.out.println(params.get(Constantes.ID_USUARIO).toString());

					Map<String, String> resultUsuUbi = usuarioDAO.registrarUbicacionUsuario(idTrans, params);

					if (resultUsuUbi.get(Constantes.CODIGO_RESPUESTA).toString().equals(Constantes.CODIGO_OK)) {

						response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REG_OK);
						response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REG_OK);

					} else {
						response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REG_USUARIO_ERROR);
						response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REG_USUARIO_ERROR);
					}

				} else {
					response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REG_USUARIO_UBI);
					response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REG_USUARIO_UBI);
				}

			} else {
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REG_USUARIO);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REG_USUARIO);
			}

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta(e.getMessage() + " : " + e);
			e.printStackTrace();
		}

		return response;

	}

	@Override
	public RegistrarUsuarioResponse registrarUsuarioV2(String idTrans, NuevoUsuarioRequest request) {

		RegistrarUsuarioResponse response = new RegistrarUsuarioResponse();

		Map<String,String> result = new HashMap<>();
		
		try {

			Usuario u = new Usuario();

			if (request.getUsuario().getIdUsuario() != 0) {
				u.setIdUsuario(request.getUsuario().getIdUsuario());
			}

			u.setApe1(request.getUsuario().getApe1());
			u.setApe2(request.getUsuario().getApe2());
			u.setNombres(request.getUsuario().getNombres());
			u.setUsuRed(request.getUsuario().getUsuRed());
			u.setFecMod(new Date());
			
			if(request.getFlag().equals(Constantes.FLAG_REGISTRAR_USUARIO)) {
				
				result = usuarioDAO.registrarUsuario(idTrans, u);
			
				response.setCodigoGenerado(Integer.valueOf(result.get(Constantes.CODIGO_GENERADO).toString()));
				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);
			
			}else if(request.getFlag().equals(Constantes.FLAG_ACTUALIZAR_USUARIO)) {
				
				result = usuarioDAO.actualizarUsuario(idTrans, u);
			
				response.setCodigoGenerado(Integer.valueOf(result.get(Constantes.CODIGO_GENERADO).toString()));
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REG_ACT);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REG_ACT);
			
				
			}else {
				
				response.setCodigoGenerado(0);
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_FLAG_INCORRECTO);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_FLAG_INCORRECTO);
			}
				

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta(e.getMessage() + " : " + e);
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public RegistrarUsuarioUbicacionResponse registrarUsuarioUbicacion(String idTrans,
			RegistrarUsuarioUbicacionRequest request) {
		
		RegistrarUsuarioUbicacionResponse response = new RegistrarUsuarioUbicacionResponse();
		
		try {
		
			Map<String, String> params = new HashMap<>();
			params.put(Constantes.ID_CONDICION, String
					.valueOf(request.getIdCondicion()));
			params.put(Constantes.ID_DOMINIO,
					String.valueOf(request.getIdDominio()));
			params.put(Constantes.ID_UBICACION,
					String.valueOf(request.getIdUbicacion() ) );
			params.put(Constantes.ID_USUARIO,
					String.valueOf(request.getIdUsuario()));

			System.out.println(params.get(Constantes.ID_CONDICION).toString());
			System.out.println(params.get(Constantes.ID_DOMINIO).toString());
			System.out.println(params.get(Constantes.ID_UBICACION).toString());
			System.out.println(params.get(Constantes.ID_USUARIO).toString());

			Map<String, String> resultUsuUbi = usuarioDAO.registrarUbicacionUsuario(idTrans, params);

			if (resultUsuUbi.get(Constantes.CODIGO_RESPUESTA).toString().equals(Constantes.CODIGO_OK)) {

				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REG_OK);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REG_OK);

			} else {
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REG_USUARIO_ERROR);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REG_USUARIO_ERROR);
			}
			
		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta(e.getMessage() + " : " + e);
			e.printStackTrace();
		}
		
		return response;
	}

}
