package pe.com.utp.inventario.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.utp.inventario.entities.Proveedor;
import pe.com.utp.inventario.util.Constantes;

@Repository(value = "proveedorDAO")
@SuppressWarnings("unchecked")
@Transactional
public class ProveedorDAOImpl implements ProveedorDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Proveedor> listarProveedor(String idTrans, String nombreProveedor) {
		
		List<Proveedor> lista = new ArrayList<Proveedor>();
		
		String sql ="";
		
		try {
			
			sql = sql + "from Proveedor p";
			
			if(!nombreProveedor.equals(Constantes.TEXTO_VACIO)||
					nombreProveedor!=null) {
				
				sql = sql + " where p.nomProveedor like '%" + nombreProveedor +"%'";
				
			}
			
			lista = em.createQuery(sql).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public Map<String, String> registrarNuevoProveedor(String idTrans, Proveedor p) {
		
		Map<String,String> out = new HashMap<>();
		
		try {
			
			List<Proveedor> registro = listarProveedor(idTrans, p.getNomProveedor());
			
			if(registro.isEmpty()) {
				
				em.persist(p);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(p.getIdProveedor()));
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
	public Map<String, String> actualizarNuevoProveedor(String idTrans, Proveedor p) {
		
		Map<String,String> out = new HashMap<>();
		
		String sql = "";
		
		try {
			
			sql = sql + "from Proveedor p where p.idProveedor =" + p.getIdProveedor();
			
			List<Proveedor> registro = em.createQuery(sql).getResultList();
			
			if(!registro.isEmpty()) {
				
				em.merge(p);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(p.getIdProveedor()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);
		
			}else {
				out.put(Constantes.CODIGO_GENERADO, "0");
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_NO_ENCONTRADO);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_NO_ENCONTRADO);
			
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
