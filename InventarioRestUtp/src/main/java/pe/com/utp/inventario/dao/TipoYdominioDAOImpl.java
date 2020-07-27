package pe.com.utp.inventario.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pe.com.utp.inventario.entities.Dominio;
import pe.com.utp.inventario.entities.TipoDispositivo;
import pe.com.utp.inventario.entities.TipoImpresora;
import pe.com.utp.inventario.entities.TipoRecurso;
import pe.com.utp.inventario.util.Constantes;

@SuppressWarnings("unchecked")
@Repository(value = "tipoDAO")
@Transactional
public class TipoYdominioDAOImpl implements TipoYdominioDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	
	@Override
	public List<TipoDispositivo> listaTipoDispositivos(String idTrans) {

		List<TipoDispositivo> tipoDispo = new ArrayList<>();
		String sql = "";

		try {

			sql = sql + "from TipoDispositivo ";

			tipoDispo = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoDispo;
	}

	@Override
	public List<TipoImpresora> listaTipoImpresora(String idTrans) {
		
		List<TipoImpresora> tipoImpresora = new ArrayList<>();
		String sql = "";

		try {

			sql = sql + "from TipoImpresora ";

			tipoImpresora = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoImpresora;
		
	}

	@Override
	public List<TipoRecurso> listaTipoRecurso(String idTrans) {
		
		List<TipoRecurso> tipoRecurso = new ArrayList<>();
		String sql = "";

		try {

			sql = sql + "from TipoRecurso ";

			tipoRecurso = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoRecurso;
	}

	@Override
	public List<Dominio> listaDominio(String idTrans) {
		
		List<Dominio> listaDominio = new ArrayList<>();
		String sql = "";

		try {

			sql = sql + "from Dominio ";

			listaDominio = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaDominio;
	}

	@Override
	public Map<String, String> nuevoTipoDispo(String idTrans, TipoDispositivo tipo) {
		
		Map<String,String> out = new HashMap<>();
		
		String sql = "";
		
		try {
			
			sql = sql + " from TipoDispositivo t where t.nomDispositivo like '%" + tipo.getNomDispositivo()  + "%'";
			
			List<TipoDispositivo> result = em.createQuery(sql).getResultList();
			
			if(result.isEmpty()) {
				
				em.persist(tipo);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(tipo.getIdTipodispositivo()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);
		
				
			}else {
				out.put(Constantes.CODIGO_GENERADO, "0");
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_EXISTE);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_EXISTE);
				
			}
			
		} catch (Exception e) {
			out.put(Constantes.CODIGO_GENERADO, "0");
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();
		}

		return out;
	}

	@Override
	public Map<String, String> nuevoTipoImpre(String idTrans, TipoImpresora impresora) {
		
		Map<String,String> out = new HashMap<>();
		
		String sql = "";
		
		try {
			
			sql = sql + "from TipoImpresora i where i.nomTipoimpresora like '%" + impresora.getNomTipoimpresora() + "%'";
			
			List<TipoImpresora> result = em.createQuery(sql).getResultList();
			
			if(result.isEmpty()) {
				
				em.persist(impresora);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(impresora.getIdTipoimpresora()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);
			}else {
				out.put(Constantes.CODIGO_GENERADO, "0");
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_EXISTE);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_EXISTE);
			}
			
		} catch (Exception e) {
			out.put(Constantes.CODIGO_GENERADO, "0");
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();
		}
		
		return out;
	}

	@Override
	public Map<String, String> nuevoTipoRecurso(String idTrans, TipoRecurso recurso) {
		
		Map<String,String> out = new HashMap<>();
		
		String sql = "";
		
		try {
			
			sql = sql + "from TipoRecurso d where d.nomTiporecurso like '%" + recurso.getNomTiporecurso()+ "%'";
			

			List<TipoImpresora> result = em.createQuery(sql).getResultList();
			
			if(result.isEmpty()) {
				
				em.persist(recurso);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(recurso.getIdTiporecurso()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);
			}else {
				out.put(Constantes.CODIGO_GENERADO, "0");
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_EXISTE);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_EXISTE);
			}
			
		} catch (Exception e) {
			out.put(Constantes.CODIGO_GENERADO, "0");
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();
		}
		
		return out;
	}

	@Override
	public Map<String, String> nuevoDominio(String idTrans, Dominio dominio) {
		
		Map<String,String> out = new HashMap<>();
		
		String sql = "";
		
		try {
			
			sql = sql + "from Dominio d where d.nomDominio like '%" + dominio.getNomDominio()+ "%'";
			

			List<TipoImpresora> result = em.createQuery(sql).getResultList();
			
			if(result.isEmpty()) {
				
				em.persist(dominio);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(dominio.getIdDominio()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);
			}else {
				out.put(Constantes.CODIGO_GENERADO, "0");
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_EXISTE);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_EXISTE);
			}
			
			
		} catch (Exception e) {
			out.put(Constantes.CODIGO_GENERADO, "0");
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();
		}
		
		return out;
	}

	

}
