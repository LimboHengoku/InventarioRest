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

import pe.com.utp.inventario.request.ListaProveedorRequest;
import pe.com.utp.inventario.request.RegistrarProveedorRequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaProveedorResponse;
import pe.com.utp.inventario.service.ProveedorService;
import pe.com.utp.inventario.util.Constantes;

@RestController
@RequestMapping(value = "/proveedor")
@CrossOrigin(origins = "*")
public class ProveedorController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProveedorService proveedorService;

	@GetMapping(value = "listar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listarProveedor() {

		ListaProveedorResponse response = new ListaProveedorResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			ListaProveedorRequest req = new ListaProveedorRequest();
			req.setNombreProveedor("");

			response = proveedorService.listarProveedores(idTrans, req);

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "consultar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> consultarProveedor(@RequestBody ListaProveedorRequest req) {

		ListaProveedorResponse response = new ListaProveedorResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			response = proveedorService.listarProveedores(idTrans, req);

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "registrar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> registrarProveedor(@RequestBody RegistrarProveedorRequest req) {

		GenericoResponse response = new GenericoResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			response = proveedorService.registrarProveedor(idTrans, req);

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping(value = "actualizar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> actualizarProveedor(@RequestBody RegistrarProveedorRequest req) {

		GenericoResponse response = new GenericoResponse();

		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);

			response = proveedorService.actualizarrProveedor(idTrans, req);

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
