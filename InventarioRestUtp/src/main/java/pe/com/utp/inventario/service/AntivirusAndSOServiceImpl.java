package pe.com.utp.inventario.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.utp.inventario.bean.SistemaOperativoBean;
import pe.com.utp.inventario.dao.AntivirusDAO;
import pe.com.utp.inventario.entities.Antivirus;
import pe.com.utp.inventario.entities.SistemaOperativo;
import pe.com.utp.inventario.mapper.AntivirusAndSOMapper;
import pe.com.utp.inventario.request.RegistrarAntivirusAndSORequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaAntivirusAndSOResponse;
import pe.com.utp.inventario.response.RegistrarAntivirusAndSOResponse;
import pe.com.utp.inventario.util.Constantes;

@Service(value = "antivirusAndSOService")
public class AntivirusAndSOServiceImpl implements AntivirusAndSOService{
	
	@Autowired
	private AntivirusDAO antivirusDAO; 
	
	
	@Override
	public ListaAntivirusAndSOResponse listarAntivirusAndSO(String idTrans) {
		
		ListaAntivirusAndSOResponse response = new ListaAntivirusAndSOResponse();
		
		List<AntivirusAndSOMapper> lista  = new ArrayList<AntivirusAndSOMapper>();
		
		try {
			
			List<Antivirus> antivirus = antivirusDAO.listarAntivirus();
			List<SistemaOperativo> so = antivirusDAO.listarSO();
			
			if(!antivirus.isEmpty()) {
				
				for(Antivirus a : antivirus) {
					AntivirusAndSOMapper x = new AntivirusAndSOMapper();
					x.setIdRecurso(a.getIdAntivirus());
					x.setNombreRecurso(a.getMarca());
					x.setEstado(a.getEstado());
					x.setFlag(Constantes.FLAG_ANTIVIRUS);
					lista.add(x);
				}
				
			}
			
			if(!so.isEmpty()) {
				
				for(SistemaOperativo b : so) {
					AntivirusAndSOMapper x = new AntivirusAndSOMapper();
					x.setIdRecurso(b.getIdSo());
					x.setNombreRecurso(b.getNomSo());
					x.setEstado(b.getEstado());
					x.setFlag(Constantes.FLAG_SO);
					lista.add(x);
				}
				
			}
			
			
			if (!lista.isEmpty()) {
				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);
			} else {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_NOEXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_NOEXITOSO);
			}
			
			response.setRecursos(lista);
			
		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}
		
		return response;
		
	}


	@Override
	public RegistrarAntivirusAndSOResponse registrarAntivirusAndSO(String idTrans, 
			RegistrarAntivirusAndSORequest req) {
		
		RegistrarAntivirusAndSOResponse response = new RegistrarAntivirusAndSOResponse();
		
		Map<String, String> result = new HashMap<>();
		
		try {
			
			if(req.getFlag().equals(Constantes.FLAG_ANTIVIRUS)) {
				
				Antivirus a = new Antivirus();
				a.setMarca(req.getRecurso().getNombreRecurso());
				a.setEstado(req.getRecurso().getEstado());
				
				result = antivirusDAO.registrarAntivirus(a);
				
				response.setCodigoRespuesta(result.get(
						Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(
						Constantes.MENSAJE_RESPUESTA).toString());

				
			}else if(req.getFlag().equals(Constantes.FLAG_SO)) {
				
				SistemaOperativo o = new SistemaOperativo();
				o.setNomSo(req.getRecurso().getNombreRecurso());
				o.setEstado(req.getRecurso().getEstado());
				
				result = antivirusDAO.registrarSO(o);
				
				response.setCodigoRespuesta(result.get(
						Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(
						Constantes.MENSAJE_RESPUESTA).toString());

				
			}else {
				
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
	public GenericoResponse actualizarAntivirusAndSO(String idTrans, RegistrarAntivirusAndSORequest req) {
		
		GenericoResponse response = new GenericoResponse(); 
		
		Map<String, String> result = new HashMap<>();
		
		try {

			if(req.getFlag().equals(Constantes.FLAG_ANTIVIRUS)) {
				
				Antivirus a = new Antivirus();
				a.setIdAntivirus(req.getRecurso().getIdRecurso());
				a.setMarca(req.getRecurso().getNombreRecurso());
				a.setEstado(req.getRecurso().getEstado());
				
				result = antivirusDAO.actualizarAntivirus(a);
				
				response.setCodigoRespuesta(result.get(
						Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(
						Constantes.MENSAJE_RESPUESTA).toString());

				
			}else if(req.getFlag().equals(Constantes.FLAG_SO)) {
				
				SistemaOperativo o = new SistemaOperativo();
				o.setIdSo(req.getRecurso().getIdRecurso());
				o.setNomSo(req.getRecurso().getNombreRecurso());
				o.setEstado(req.getRecurso().getEstado());
				
				result = antivirusDAO.actualizarSO(o);
				
				response.setCodigoRespuesta(result.get(
						Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(
						Constantes.MENSAJE_RESPUESTA).toString());

				
			}else {
				
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
