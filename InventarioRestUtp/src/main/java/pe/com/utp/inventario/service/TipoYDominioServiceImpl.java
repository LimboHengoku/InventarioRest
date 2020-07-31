package pe.com.utp.inventario.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.utp.inventario.dao.TipoYdominioDAO;
import pe.com.utp.inventario.entities.Dominio;
import pe.com.utp.inventario.entities.TipoDispositivo;
import pe.com.utp.inventario.entities.TipoImpresora;
import pe.com.utp.inventario.entities.TipoRecurso;
import pe.com.utp.inventario.mapper.TipoDominioMapperBean;
import pe.com.utp.inventario.mapper.TipoYDominioMapper;
import pe.com.utp.inventario.request.RegistrarTipoYDominioRequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaTipoYDominioResponse;
import pe.com.utp.inventario.util.Constantes;

@Service(value = "tipoService")
public class TipoYDominioServiceImpl implements TipoYDominioService {

	@Autowired
	private TipoYdominioDAO tipoDAO;

	@Override
	public ListaTipoYDominioResponse listaTipoYdominio(String idTrans) {

		ListaTipoYDominioResponse response = new ListaTipoYDominioResponse();
		List<TipoYDominioMapper> lista = new ArrayList<>();

		try {
			int idNuevo = 0;

			List<TipoDispositivo> tipoDispo = tipoDAO.listaTipoDispositivos(idTrans);
			List<TipoImpresora> tipoImpresora = tipoDAO.listaTipoImpresora(idTrans);
			List<TipoRecurso> tipoRecurso = tipoDAO.listaTipoRecurso(idTrans);
			List<Dominio> tipoDominio = tipoDAO.listaDominio(idTrans);

			if (!tipoDispo.isEmpty()) {

				for (TipoDispositivo x : tipoDispo) {
//					idNuevo++;
					TipoYDominioMapper bean = new TipoYDominioMapper();
					bean.setIdTipodispositivo(x.getIdTipodispositivo());
					bean.setNomDispositivo(x.getNomDispositivo());
					bean.setFechaRegistro(x.getFechaRegistro());
					bean.setFlag(Constantes.FLAG_TIPO_DISPOSITIVO);
					bean.setEstadoRegistro(x.getEstado());
					lista.add(bean);

				}

			}

			if (!tipoImpresora.isEmpty()) {
				for (TipoImpresora y : tipoImpresora) {
//					idNuevo++;
					TipoYDominioMapper bean = new TipoYDominioMapper();
					bean.setIdTipodispositivo(y.getIdTipoimpresora());
					bean.setNomDispositivo(y.getNomTipoimpresora());
					bean.setFlag(Constantes.FLAG_TIPO_IMPRESORA);
					bean.setEstadoRegistro(y.getEstado());
					lista.add(bean);
				}
			}

			if (!tipoRecurso.isEmpty()) {
				for (TipoRecurso z : tipoRecurso) {
//					idNuevo++;
					TipoYDominioMapper bean = new TipoYDominioMapper();
					bean.setIdTipodispositivo(z.getIdTiporecurso());
					bean.setNomDispositivo(z.getNomTiporecurso());
					bean.setFlag(Constantes.FLAG_TIPO_RECURSO);
					bean.setEstadoRegistro(z.getEstado());
					lista.add(bean);
				}
			}

			if (!tipoDominio.isEmpty()) {
				for (Dominio a : tipoDominio) {
//					idNuevo++;
					TipoYDominioMapper bean = new TipoYDominioMapper();
					bean.setIdTipodispositivo(a.getIdDominio());
					bean.setNomDispositivo(a.getNomDominio());
					bean.setFlag(Constantes.FLAG_TIPO_DOMINIO);
					bean.setEstadoRegistro(a.getEstado());
					lista.add(bean);
				}
			}

			if (!lista.isEmpty()) {
				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);
			} else {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_NOEXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_NOEXITOSO);
			}

			response.setListaTipoYDominio(lista);

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public GenericoResponse registrarTipoYDominio(String idTraString, RegistrarTipoYDominioRequest req) {

		GenericoResponse response = new GenericoResponse();

		Map<String, String> result = new HashMap<>();

		try {

			if (req.getFlag().equals(Constantes.FLAG_TIPO_DISPOSITIVO)) {

				TipoDispositivo tipo = new TipoDispositivo();
				tipo.setNomDispositivo(req.getTipoDominio().getNomDispositivo());
				tipo.setFechaRegistro(new Date());
				tipo.setEstado(req.getTipoDominio().getEstadoRegistro());

				result = tipoDAO.nuevoTipoDispo(idTraString, tipo);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else if (req.getFlag().equals(Constantes.FLAG_TIPO_IMPRESORA)) {

				TipoImpresora impresora = new TipoImpresora();
				impresora.setNomTipoimpresora(req.getTipoDominio().getNomDispositivo());
				impresora.setEstado(req.getTipoDominio().getEstadoRegistro());
				
				result = tipoDAO.nuevoTipoImpre(idTraString, impresora);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else if (req.getFlag().equals(Constantes.FLAG_TIPO_RECURSO)) {

				TipoRecurso recurso = new TipoRecurso();
				recurso.setNomTiporecurso(req.getTipoDominio().getNomDispositivo());
				recurso.setEstado(req.getTipoDominio().getEstadoRegistro());
				
				result = tipoDAO.nuevoTipoRecurso(idTraString, recurso);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else if (req.getFlag().equals(Constantes.FLAG_TIPO_DOMINIO)) {
				Dominio dom = new Dominio();
				dom.setNomDominio(req.getTipoDominio().getNomDispositivo());
				dom.setEstado(req.getTipoDominio().getEstadoRegistro());
				
				result = tipoDAO.nuevoDominio(idTraString, dom);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else {
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_FLAG_INCORRECTO);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_FLAG_INCORRECTO);
			}

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}

		return response;

	}

	@Override
	public GenericoResponse actualizarTipoYDominio(String idTraString, RegistrarTipoYDominioRequest req) {

		GenericoResponse response = new GenericoResponse();

		Map<String, String> result = new HashMap<>();

		try {

			if (req.getFlag().equals(Constantes.FLAG_TIPO_DISPOSITIVO)) {

				TipoDispositivo tipo = new TipoDispositivo();
				tipo.setIdTipodispositivo(req.getTipoDominio().getIdTipodispositivo());
				tipo.setNomDispositivo(req.getTipoDominio().getNomDispositivo());
				tipo.setFechaRegistro(new Date());
				tipo.setEstado(req.getTipoDominio().getEstadoRegistro());

				result = tipoDAO.actualizarTipoDispo(idTraString, tipo);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else if (req.getFlag().equals(Constantes.FLAG_TIPO_IMPRESORA)) {

				TipoImpresora impresora = new TipoImpresora();
				impresora.setIdTipoimpresora(req.getTipoDominio().getIdTipodispositivo());
				impresora.setNomTipoimpresora(req.getTipoDominio().getNomDispositivo());
				impresora.setEstado(req.getTipoDominio().getEstadoRegistro());
				
				result = tipoDAO.actualizarTipoImpre(idTraString, impresora);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else if (req.getFlag().equals(Constantes.FLAG_TIPO_RECURSO)) {

				TipoRecurso recurso = new TipoRecurso();
				recurso.setIdTiporecurso(req.getTipoDominio().getIdTipodispositivo());
				recurso.setNomTiporecurso(req.getTipoDominio().getNomDispositivo());
				recurso.setEstado(req.getTipoDominio().getEstadoRegistro());
				
				result = tipoDAO.actualizarTipoRecurso(idTraString, recurso);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else if (req.getFlag().equals(Constantes.FLAG_TIPO_DOMINIO)) {
				Dominio dom = new Dominio();
				dom.setIdDominio(req.getTipoDominio().getIdTipodispositivo());
				dom.setNomDominio(req.getTipoDominio().getNomDispositivo());
				dom.setEstado(req.getTipoDominio().getEstadoRegistro());

				result = tipoDAO.actualizarDominio(idTraString, dom);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else {
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_FLAG_INCORRECTO);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_FLAG_INCORRECTO);
			}

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}

		return response;

	}



	@Override
	public GenericoResponse eliminarTipoYDominio(String idTraString, RegistrarTipoYDominioRequest req) {

		GenericoResponse response = new GenericoResponse();

		Map<String, String> result = new HashMap<>();

		try {

			if (req.getFlag().equals(Constantes.FLAG_TIPO_DISPOSITIVO)) {

				TipoDispositivo tipo = new TipoDispositivo();
				tipo.setIdTipodispositivo(req.getTipoDominio().getIdTipodispositivo());
				tipo.setNomDispositivo(req.getTipoDominio().getNomDispositivo());
				tipo.setEstado(Constantes.ELIMINAR);
//				tipo.setFechaRegistro(new Date());

				result = tipoDAO.eliminarTipoDispo(idTraString, tipo);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else if (req.getFlag().equals(Constantes.FLAG_TIPO_IMPRESORA)) {

				TipoImpresora impresora = new TipoImpresora();
				impresora.setIdTipoimpresora(req.getTipoDominio().getIdTipodispositivo());
				impresora.setNomTipoimpresora(req.getTipoDominio().getNomDispositivo());
				impresora.setEstado(Constantes.ELIMINAR);
				
				result = tipoDAO.eliminarTipoImpre(idTraString, impresora);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else if (req.getFlag().equals(Constantes.FLAG_TIPO_RECURSO)) {

				TipoRecurso recurso = new TipoRecurso();
				recurso.setIdTiporecurso(req.getTipoDominio().getIdTipodispositivo());
				recurso.setNomTiporecurso(req.getTipoDominio().getNomDispositivo());
				recurso.setEstado(Constantes.ELIMINAR);
				result = tipoDAO.eliminarTipoRecurso(idTraString, recurso);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else if (req.getFlag().equals(Constantes.FLAG_TIPO_DOMINIO)) {
				Dominio dom = new Dominio();
				dom.setIdDominio(req.getTipoDominio().getIdTipodispositivo());
				dom.setNomDominio(req.getTipoDominio().getNomDispositivo());
				dom.setEstado(Constantes.ELIMINAR);
				
				result = tipoDAO.eliminarDominio(idTraString, dom);

				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else {
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_FLAG_INCORRECTO);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_FLAG_INCORRECTO);
			}

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}

		return response;

	}


}
