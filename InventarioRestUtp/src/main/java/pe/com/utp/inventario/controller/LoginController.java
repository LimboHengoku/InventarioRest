package pe.com.utp.inventario.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.utp.inventario.request.LoginRequest;
import pe.com.utp.inventario.response.LoginResponse;
import pe.com.utp.inventario.service.UsuarioService;
import pe.com.utp.inventario.util.Constantes;

@RestController
@RequestMapping(value = "/")
public class LoginController implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "login",headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> login(@RequestBody LoginRequest req){
		
		LoginResponse response = new LoginResponse();
		
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = usuarioService.login(idTrans, req);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
}
