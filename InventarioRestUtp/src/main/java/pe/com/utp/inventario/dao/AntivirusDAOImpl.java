package pe.com.utp.inventario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.utp.inventario.entities.Antivirus;

@Repository(value = "antivirusDAO")
@SuppressWarnings("unchecked")
@Transactional
public class AntivirusDAOImpl implements AntivirusDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Antivirus> listarAntivirus() {
		
		List<Antivirus> lista = new ArrayList<>();
		
		String sql = "";
		
		try {
			
			sql = sql + "from Antivirus a";
			
			lista = em.createQuery(sql).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	} 
	
}
