package pe.com.utp.inventario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pe.com.utp.inventario.entities.Estado;
 

@Repository(value = "estadoDAO")
@SuppressWarnings("unchecked")
@Transactional
public class EstadoDAOImpl implements EstadoDAO{

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Estado> listarEstados(String idTrans) {
		
		List<Estado> lista = new ArrayList<>();
		
		String sql = "";
		
		 try {
			 
			 sql = sql + "from Estado e";
			 
			 lista = em.createQuery(sql).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return lista;
	}

 

	
}
