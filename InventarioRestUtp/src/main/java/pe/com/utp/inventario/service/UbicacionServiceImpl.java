package pe.com.utp.inventario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.utp.inventario.bean.DivisionBean;
import pe.com.utp.inventario.bean.OficinaBean;
import pe.com.utp.inventario.bean.SedeBean;
import pe.com.utp.inventario.bean.UbicacionBean;
import pe.com.utp.inventario.dao.UbicacionDAO;
import pe.com.utp.inventario.entities.Division;
import pe.com.utp.inventario.entities.Oficina;
import pe.com.utp.inventario.entities.Sede;
import pe.com.utp.inventario.entities.Ubicacion;
import pe.com.utp.inventario.request.ListaUbicacionRequest;
import pe.com.utp.inventario.request.RegistrarUbicacionRequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListarUbicacionesResponse;
import pe.com.utp.inventario.response.RegistrarUbicacionResponse;
import pe.com.utp.inventario.util.Constantes;

@Service(value = "ubicacionService")
public class UbicacionServiceImpl implements UbicacionService {

	@Autowired
	private UbicacionDAO ubicacionDAO;

	@Override
	public ListarUbicacionesResponse listarUbicacion(String idTransaccion) {

		ListarUbicacionesResponse response = new ListarUbicacionesResponse();

		List<UbicacionBean> ubicaciones = new ArrayList<>();
		List<SedeBean> sedes = new ArrayList<>();
		List<DivisionBean> divisiones = new ArrayList<>();
		List<OficinaBean> oficinas = new ArrayList<>();

		try {
 
			List<Sede> listaSede = ubicacionDAO.listarSedes(idTransaccion);
			List<Division> listaDivision = ubicacionDAO.listarDivision(idTransaccion);
			List<Oficina> listaOficinas = ubicacionDAO.listarOficinas(idTransaccion);

			if (!listaSede.isEmpty()) {

				for (Sede s : listaSede) {
					SedeBean bean = new SedeBean();
					bean.setIdSede(s.getIdSede());
					bean.setNomSede(s.getNomSede());
					sedes.add(bean);
				}

			}

			if (!listaDivision.isEmpty()) {

				for (Division d: listaDivision) {
					DivisionBean bean = new DivisionBean();
					bean.setIdDivision(d.getIdDivision());
					bean.setNomDivision(d.getNomDivision());
					divisiones.add(bean);
				}

			}

			if (!listaOficinas.isEmpty()) {
				
				for (Oficina o: listaOficinas) {
					OficinaBean bean = new OficinaBean();
					bean.setIdOficina(o.getIdOficina());
					bean.setNomOficina(o.getNomOficina());
					oficinas.add(bean);
				}
			}

			
			response.setSedes(sedes);
			response.setDivisiones(divisiones);
			response.setOficinas(oficinas);

			response.setCodigoRespuesta(Constantes.CODIGO_OK);
			response.setMensajeRespuesta(Constantes.MENSAJE_OK);

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta(e.getMessage() + " : " + e);
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public RegistrarUbicacionResponse generarIdUbicacion(String idTransaccion, RegistrarUbicacionRequest req) {
		
		RegistrarUbicacionResponse response = new RegistrarUbicacionResponse();
		
		try {
			
			Ubicacion u = new Ubicacion();
			
			Sede s = new Sede();
			s.setIdSede(req.getIdSede());
			
			Division d = new Division();
			d.setIdDivision(req.getIdDivision());
			
			Oficina o = new Oficina();
			o.setIdOficina(req.getIdOficina());
			
			u.setSede(s);
			u.setDivision(d);
			u.setOficina(o);
			
			Map<String,String> out = 
					ubicacionDAO.registrarUbicacion(idTransaccion, u);
			
			response.setCodigoGenerado(Integer.valueOf(
					out.get(Constantes.CODIGO_GENERADO).toString()));
			response.setCodigoRespuesta(out.get(Constantes.CODIGO_RESPUESTA).toString());
			response.setMensajeRespuesta(out.get(Constantes.MENSAJE_RESPUESTA).toString());
		
			
		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta(e.getMessage() + " : " + e);
			e.printStackTrace();
		}
		
		return response;
	}




}
