package pe.com.utp.inventario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.utp.inventario.entities.Cpu;

@Repository(value = "cpuDAO")
@SuppressWarnings("unchecked")
@Transactional
public class CpuDAOImpl implements CpuDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Cpu> listarProcesador() {
		
		List<Cpu> lista = new ArrayList<>();
		
		String sql = "";
		
		try {
			
			sql = sql + "from Cpu ";
			
			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
