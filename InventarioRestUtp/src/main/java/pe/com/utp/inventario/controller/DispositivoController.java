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

import pe.com.utp.inventario.request.DetalleDispositivoRequest;
import pe.com.utp.inventario.request.ListaDispositivoRequest;
import pe.com.utp.inventario.request.RegistrarDispositivoRequest;
import pe.com.utp.inventario.response.DetalleDispositivoResponse;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaDispositivoResponse;
import pe.com.utp.inventario.response.ListarAntivirusResponse;
import pe.com.utp.inventario.service.DispositivoService;
import pe.com.utp.inventario.util.Constantes;

@RestController
@RequestMapping(value = "/dispositivo")
@CrossOrigin(origins = "*")
public class DispositivoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private DispositivoService dispositivoService;
	
	@GetMapping(value = "listar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listarDispositivos(){
		
		ListaDispositivoResponse response = new ListaDispositivoResponse();
		
		try {
			
			ListaDispositivoRequest req = new ListaDispositivoRequest();
			req.setNombreDispo("");
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = dispositivoService.listarDispositivos(idTrans, req);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
		
	}
	
	
	@PostMapping(value = "consultar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> consultarDispositivos(@RequestBody 
			ListaDispositivoRequest req){
		
		ListaDispositivoResponse response = new ListaDispositivoResponse();
		
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = dispositivoService.listarDispositivos(idTrans, req);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
		
	}
	
	@PostMapping(value = "registrar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> registrarDispositivo(@RequestBody 
			RegistrarDispositivoRequest req){
		
		GenericoResponse response = new GenericoResponse();
		
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = dispositivoService.registrarDispositivo(idTrans, req);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
		
	}


	@PostMapping(value = "actualizar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> actualizarDispositivo(@RequestBody 
			RegistrarDispositivoRequest req){
		
		GenericoResponse response = new GenericoResponse();
		
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = dispositivoService.actualizarDispositivo(idTrans, req);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
		
	}
	
	
	@PostMapping(value = "detalle", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> obtenerDetalleDispositivo(@RequestBody 
			DetalleDispositivoRequest req){
		
		DetalleDispositivoResponse response = new DetalleDispositivoResponse();
		
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = dispositivoService.obtenerDetalleDispositivo(idTrans, req);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
		
	}
	

}
