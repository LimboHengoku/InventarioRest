package pe.com.utp.inventario.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.utp.inventario.request.NuevoUsuarioRequest;
import pe.com.utp.inventario.request.RegistrarUsuarioRequest;
import pe.com.utp.inventario.request.RegistrarUsuarioUbicacionRequest;
import pe.com.utp.inventario.response.ListaRolResponse;
import pe.com.utp.inventario.response.ListaUsuarioResponse;
import pe.com.utp.inventario.response.RegistrarUsuarioResponse;
import pe.com.utp.inventario.response.RegistrarUsuarioUbicacionResponse;
import pe.com.utp.inventario.service.UsuarioService;
import pe.com.utp.inventario.util.Constantes;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "listar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listarUsuarios() {

		ListaUsuarioResponse response = new ListaUsuarioResponse();

		try {

			response = usuarioService.listarUsuarios();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping(value = "roles", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listarRoles() {

		ListaRolResponse response = new ListaRolResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			response = usuarioService.listarRoles(idTrans);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping(value = "registrar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> registrarUsuario(@RequestBody NuevoUsuarioRequest request) {

		RegistrarUsuarioResponse response = new RegistrarUsuarioResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			response = usuarioService.registrarUsuarioV2(idTrans, request);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping(value = "ubicacion/registrar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> registrarUsuariobicacion(@RequestBody RegistrarUsuarioUbicacionRequest request) {

		RegistrarUsuarioUbicacionResponse response = new RegistrarUsuarioUbicacionResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			response = usuarioService.registrarUsuarioUbicacion(idTrans, request);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
