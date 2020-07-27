package pe.com.utp.inventario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.utp.inventario.bean.ProveedorBean;
import pe.com.utp.inventario.dao.ProveedorDAO;
import pe.com.utp.inventario.entities.Proveedor;
import pe.com.utp.inventario.request.ListaProveedorRequest;
import pe.com.utp.inventario.request.RegistrarProveedorRequest;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaProveedorResponse;
import pe.com.utp.inventario.util.Constantes;

@Service(value = "proveedorService")
public class ProveedorServiceImpl implements ProveedorService{

	
	@Autowired
	private ProveedorDAO proveedorDAO;

	@Override
	public ListaProveedorResponse listarProveedores(String idTrans,
			ListaProveedorRequest req) {
		
		ListaProveedorResponse response = new ListaProveedorResponse();
		
		List<ProveedorBean> proveedores = new ArrayList<ProveedorBean>();
		
		try {
			
			List<Proveedor> lista = 
					proveedorDAO.listarProveedor(idTrans, req.getNombreProveedor());
			
			if(!lista.isEmpty()) {
				
				for(Proveedor x : lista) {
					ProveedorBean bean = new ProveedorBean();
					bean.setIdProveedor(x.getIdProveedor());
					bean.setNomProveedor(x.getNomProveedor());
					bean.setObservacion(x.getObservacion());
					bean.setNroDocumento(x.getNroDocumento());
					bean.setTipoDocumento(x.getTipoDocumento());
					
					proveedores.add(bean);
				}
				
				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);
				
			}else {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_NOEXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_NOEXITOSO);
		
			}
			
			response.setProveedores(proveedores);
			
			
		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}
		
		return response;
		
	}

	@Override
	public GenericoResponse registrarProveedor(String idTrans, 
			RegistrarProveedorRequest req) {
		
		GenericoResponse response = new GenericoResponse();
		
		try {
			
			Proveedor prov = new Proveedor();
			prov.setNomProveedor(req.getProveedor().getNomProveedor());
			prov.setObservacion(req.getProveedor().getObservacion());
			
			Map<String,String> result = proveedorDAO
					.registrarNuevoProveedor(idTrans, prov);
			
			response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA)
					.toString());
			response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA)
					.toString());
			
		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
		}
		
		return response;
		
	}

	@Override
	public GenericoResponse actualizarrProveedor(String idTrans, 
				RegistrarProveedorRequest req) {
		
		GenericoResponse response = new GenericoResponse();
		
		try {
			
			Proveedor prov = new Proveedor();
			prov.setIdProveedor(req.getProveedor().getIdProveedor());
			prov.setNomProveedor(req.getProveedor().getNomProveedor());
			prov.setObservacion(req.getProveedor().getObservacion());
			
			Map<String,String> result = proveedorDAO
					.actualizarNuevoProveedor(idTrans, prov);
			
			response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA)
					.toString());
			response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA)
					.toString());
			
		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
		}
		
		return response;
	}
	
	
	
}
