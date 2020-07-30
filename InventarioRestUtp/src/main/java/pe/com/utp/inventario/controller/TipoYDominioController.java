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

import pe.com.utp.inventario.request.RegistrarTipoYDominioRequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaTipoYDominioResponse;
import pe.com.utp.inventario.service.TipoYDominioService;
import pe.com.utp.inventario.util.Constantes;

@RestController
@RequestMapping(value = "/tipoYDominio")
@CrossOrigin(origins = "*")
public class TipoYDominioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TipoYDominioService tipoService;

	@GetMapping(value = "listar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listarTiposYDominios() {

		ListaTipoYDominioResponse response = new ListaTipoYDominioResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			response = tipoService.listaTipoYdominio(idTrans);

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "registrar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> registrarTipoYDominio(@RequestBody RegistrarTipoYDominioRequest req) {

		GenericoResponse response = new GenericoResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			response = tipoService.registrarTipoYDominio(idTrans, req);

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@PostMapping(value = "actualizar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> actualizarTipoYDominio(@RequestBody RegistrarTipoYDominioRequest req) {

		GenericoResponse response = new GenericoResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			response = tipoService.actualizarTipoYDominio(idTrans, req);

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
