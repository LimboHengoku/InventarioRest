package pe.com.utp.inventario.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import pe.com.utp.inventario.entities.Division;
import pe.com.utp.inventario.entities.Oficina;
import pe.com.utp.inventario.entities.Sede;
import pe.com.utp.inventario.entities.Ubicacion;
import pe.com.utp.inventario.util.Constantes;

@Repository(value = "ubicacionDAO")
@SuppressWarnings("unchecked")
@Transactional
public class UbicacionDAOImpl implements UbicacionDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Sede> listarSedes(String idTransaccion) {

		List<Sede> lista = new ArrayList<>();

		String sql = "";

		try {

			sql = sql + "from Sede s";

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public List<Division> listarDivision(String idTransaccion) {
		
		List<Division> lista = new ArrayList<>();

		String sql = "";

		try {

			sql = sql + "from Division di";

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public List<Oficina> listarOficinas(String idTransaccion) {
		
		List<Oficina> lista = new ArrayList<>();

		String sql = "";

		try {

			sql = sql + "from Oficina o";

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public List<Ubicacion> listaUbicacion(String idTransaccion) {
		List<Ubicacion> lista = new ArrayList<>();

		String sql = "";

		try {

			sql = sql + "from Ubicacion o";

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Map<String, String> registrarUbicacion(String idTransaccion, Ubicacion u) {
		
		Map<String, String> out = new HashMap<>();
		
		try {
			
			String sql = "from Ubicacion u where u.sede.idSede = "
					+ u.getSede().getIdSede() + " and u.division.idDivision =" 
					+ u.getDivision().getIdDivision() + " and u.oficina.idOficina ="
					+ u.getOficina().getIdOficina();
			
			List<Ubicacion> reg = em.createQuery(sql).getResultList();
			
			System.out.println("reg.size() " + reg.size());
			
			em.persist(u);
			
			out.put(Constantes.CODIGO_GENERADO, String.valueOf(u.getIdUbicacion()));
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
			out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);
			
//			if(reg.isEmpty()) {
//				
//				out.put(Constantes.CODIGO_GENERADO, String.valueOf(u.getIdUbicacion()));
//				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
//				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);
//				
//
//			}else {
//				System.out.println(u.getIdUbicacion());
//				for(Ubicacion aux : reg) {
//					System.out.println(aux.getIdUbicacion());
//					if(aux.getIdUbicacion() == u.getIdUbicacion()) {
//						em.merge(u);
//						
//						break;
//					}
//				}
//				
//				
//				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_ACT);
//				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_ACT);
//				out.put(Constantes.CODIGO_GENERADO, String.valueOf(u.getIdUbicacion()));
//				
//
//			}
			
		} catch (Exception e) {
			out.put(Constantes.CODIGO_GENERADO, "0");
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + " : " + e);
			e.printStackTrace();
		}
		
		return out;
	}

}
