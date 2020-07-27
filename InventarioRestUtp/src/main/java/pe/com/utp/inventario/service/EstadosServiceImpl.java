package pe.com.utp.inventario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.utp.inventario.bean.EstadoBean;
import pe.com.utp.inventario.dao.EstadoDAO;
import pe.com.utp.inventario.entities.Estado;
import pe.com.utp.inventario.response.ListaEstadoResponse;
import pe.com.utp.inventario.util.Constantes;

@Service(value = "estadoService")
public class EstadosServiceImpl implements EstadosService{

	@Autowired
	private EstadoDAO estadoDAO;

	@Override
	public ListaEstadoResponse listarEstados(String idTrans) {
		
		ListaEstadoResponse response = new ListaEstadoResponse();
		
		List<EstadoBean> estados = new ArrayList<>();
		
		try {
			
			List<Estado> lista =
					estadoDAO.listarEstados(idTrans);
			
			if(!lista.isEmpty()) {
				
				for(Estado e : lista) {
					EstadoBean bean = new EstadoBean();
					bean.setIdEstado(e.getIdEstado());
					bean.setNomEstado(e.getNomEstado());
					estados.add(bean);
				}
				
				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);
			
				
			}else {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_NOEXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_NOEXITOSO);
		
			}
			
			response.setEstados(estados);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	
}
