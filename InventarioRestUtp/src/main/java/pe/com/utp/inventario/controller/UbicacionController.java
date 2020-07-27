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

import pe.com.utp.inventario.request.RegistrarDispositivoRequest;
import pe.com.utp.inventario.request.RegistrarUbicacionRequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListarUbicacionesResponse;
import pe.com.utp.inventario.response.RegistrarUbicacionResponse;
import pe.com.utp.inventario.service.UbicacionService;
import pe.com.utp.inventario.util.Constantes;

@RestController
@RequestMapping(value = "/ubicacion")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class UbicacionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UbicacionService ubicacionService;

	@GetMapping(value = "listar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listarUbicaciones() {

		ListarUbicacionesResponse response = new ListarUbicacionesResponse();

		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = ubicacionService.listarUbicacion(idTrans);

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "generarId", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> registrarDispositivo(@RequestBody 
			RegistrarUbicacionRequest req){
		
		RegistrarUbicacionResponse response = new RegistrarUbicacionResponse();
		
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = ubicacionService.generarIdUbicacion(idTrans, req);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
		
	}

}
