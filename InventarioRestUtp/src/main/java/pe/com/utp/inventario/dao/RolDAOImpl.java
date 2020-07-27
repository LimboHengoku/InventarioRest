package pe.com.utp.inventario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.utp.inventario.entities.TipoLogueo;

@Repository(value = "rolDAO")
@SuppressWarnings("unchecked")
@Transactional
public class RolDAOImpl implements RolDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TipoLogueo> listarRoles(String idTrans) {
		
		List<TipoLogueo> lista = new ArrayList<>();
		
		String sql = "";
		
		try {
			
			sql = sql + "from TipoLogueo r";
			
			lista = em.createQuery(sql).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	
	
}
