package pe.com.utp.inventario.dao;

import java.util.List;
import java.util.Map;

import pe.com.utp.inventario.entities.Dominio;
import pe.com.utp.inventario.entities.TipoDispositivo;
import pe.com.utp.inventario.entities.TipoImpresora;
import pe.com.utp.inventario.entities.TipoRecurso;

public interface TipoYdominioDAO {

	public List<TipoDispositivo> listaTipoDispositivos(String idTrans);
	public List<TipoImpresora> listaTipoImpresora(String idTrans);
	public List<TipoRecurso> listaTipoRecurso(String idTrans);
	public List<Dominio> listaDominio(String idTrans);
	
	
	public Map<String, String> nuevoTipoDispo(String idTrans,TipoDispositivo tipo);
	public Map<String, String> nuevoTipoImpre(String idTrans, TipoImpresora impresora);
	public Map<String, String> nuevoTipoRecurso(String idTrans, TipoRecurso recurso);
	public Map<String, String> nuevoDominio(String idTrans,Dominio dominio);
	
	public Map<String, String> actualizarTipoDispo(String idTrans,TipoDispositivo tipo);
	public Map<String, String> actualizarTipoImpre(String idTrans, TipoImpresora impresora);
	public Map<String, String> actualizarTipoRecurso(String idTrans, TipoRecurso recurso);
	public Map<String, String> actualizarDominio(String idTrans,Dominio dominio);
	
	public Map<String, String> eliminarTipoDispo(String idTrans,TipoDispositivo tipo);
	public Map<String, String> eliminarTipoImpre(String idTrans, TipoImpresora impresora);
	public Map<String, String> eliminarTipoRecurso(String idTrans, TipoRecurso recurso);
	public Map<String, String> eliminarDominio(String idTrans,Dominio dominio);
	
	
}
