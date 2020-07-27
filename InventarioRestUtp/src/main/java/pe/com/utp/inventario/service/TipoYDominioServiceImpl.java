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
public class TipoYDominioServiceImpl implements TipoYDominioService{
	
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
			
			if(!tipoDispo.isEmpty()) {
				
				for(TipoDispositivo x : tipoDispo) {
					idNuevo++;
					TipoYDominioMapper bean = new TipoYDominioMapper();
					bean.setIdTipodispositivo(idNuevo);
					bean.setNomDispositivo(x.getNomDispositivo());
					bean.setFechaRegistro(x.getFechaRegistro());
					bean.setFlag(Constantes.FLAG_TIPO_DISPOSITIVO);
					lista.add(bean);
					
				}
				
			}
			
			if(!tipoImpresora.isEmpty()) {
				for(TipoImpresora y : tipoImpresora) {
					idNuevo++;
					TipoYDominioMapper bean = new TipoYDominioMapper();					
					bean.setIdTipodispositivo(idNuevo);
					bean.setNomDispositivo(y.getNomTipoimpresora());
					bean.setFlag(Constantes.FLAG_TIPO_IMPRESORA);
					lista.add(bean);
				}
			}
			
			if(!tipoRecurso.isEmpty()) {
				for(TipoRecurso z : tipoRecurso) {
					idNuevo++;
					TipoYDominioMapper bean = new TipoYDominioMapper();
					bean.setIdTipodispositivo(idNuevo);
					bean.setNomDispositivo(z.getNomTiporecurso()); 
					bean.setFlag(Constantes.FLAG_TIPO_RECURSO);
					lista.add(bean);
				}
			}
			
			if(!tipoDominio.isEmpty()) {
				for(Dominio a : tipoDominio) {
					idNuevo++;
					TipoYDominioMapper bean = new TipoYDominioMapper();
					bean.setIdTipodispositivo(idNuevo);
					bean.setNomDispositivo(a.getNomDominio());
					bean.setFlag(Constantes.FLAG_TIPO_DOMINIO);
					lista.add(bean);
				}
			}
			
			if(!lista.isEmpty()) {
				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);
			}else {
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
		
		Map<String,String> result = new HashMap<>();
		
		try {
			
			if(req.getFlag().equals(Constantes.FLAG_TIPO_DISPOSITIVO)) {
				
				TipoDispositivo tipo = new TipoDispositivo();
				tipo.setNomDispositivo(req.getTipoDominio().getNomDispositivo());
				tipo.setFechaRegistro(new Date());
				
				result = tipoDAO.nuevoTipoDispo(idTraString, tipo);
				
				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA)
						.toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA)
						.toString());
				
			}else if(req.getFlag().equals(Constantes.FLAG_TIPO_IMPRESORA)) {
				
				TipoImpresora impresora = new TipoImpresora();
				impresora.setNomTipoimpresora(req.getTipoDominio().getNomDispositivo());
				
				result = tipoDAO.nuevoTipoImpre(idTraString, impresora);
				
				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA)
						.toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA)
						.toString());
				
			}else if(req.getFlag().equals(Constantes.FLAG_TIPO_RECURSO)) {
				
				TipoRecurso recurso = new TipoRecurso();
				recurso.setNomTiporecurso(req.getTipoDominio().getNomDispositivo());
				
				result = tipoDAO.nuevoTipoRecurso(idTraString, recurso);
				
				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA)
						.toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA)
						.toString());
				
			}else if(req.getFlag().equals(Constantes.FLAG_TIPO_DOMINIO)) {
				Dominio dom = new Dominio();
				dom.setNomDominio(req.getTipoDominio().getNomDispositivo());
				
				result = tipoDAO.nuevoDominio(idTraString, dom);
				
				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA)
						.toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA)
						.toString());
				
			}else{
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
