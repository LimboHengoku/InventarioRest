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
import org.springframework.web.bind.annotation.RestController;

import pe.com.utp.inventario.request.RegistrarAntivirusAndSORequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaAntivirusAndSOResponse;
import pe.com.utp.inventario.response.RegistrarAntivirusAndSOResponse;
import pe.com.utp.inventario.service.AntivirusAndSOService;
import pe.com.utp.inventario.util.Constantes;

@RestController
@RequestMapping(value = "/antivirusYSo")
@CrossOrigin(origins = "*")
public class AntivirusYSOController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AntivirusAndSOService antivirusAndSOService;
	
	@GetMapping(value = "listar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listar(){
		
		ListaAntivirusAndSOResponse response = new ListaAntivirusAndSOResponse();
		
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = antivirusAndSOService.listarAntivirusAndSO(idTrans);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
		
	}
	
	
	@PostMapping(value = "registrar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> nuevo(@RequestBody RegistrarAntivirusAndSORequest req){
		
		RegistrarAntivirusAndSOResponse response = new RegistrarAntivirusAndSOResponse();
		
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = antivirusAndSOService.registrarAntivirusAndSO(idTrans, req);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}
	
	
	@PostMapping(value = "registrar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> actualizar(@RequestBody RegistrarAntivirusAndSORequest req){
		
		GenericoResponse response = new GenericoResponse();
		
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = antivirusAndSOService.actualizarAntivirusAndSO(idTrans, req);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}
	
}
