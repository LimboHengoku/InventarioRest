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

import pe.com.utp.inventario.entities.Dispositivo;
import pe.com.utp.inventario.entities.DispositivoUsuario;
import pe.com.utp.inventario.util.Constantes;

@Repository(value = "dispositivoDAO")
@SuppressWarnings("unchecked")
@Transactional
public class DispositivoDAOImpl implements DispositivoDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	@Override
	public int cantidadDispositivosActivos(String idTrans) {

		int cantidadDispo = 0;

		String sql = "";

		try {

			sql = sql + "select * from Dispositivo d " + "where d.estado.idEstado = 1";

			List<Dispositivo> registros = em.createQuery(sql).getResultList();

			cantidadDispo = registros.size();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cantidadDispo;
	}

	@Override
	public List<Dispositivo> listaDispositivos(String idTrans, String nombreDispo) {

		List<Dispositivo> lista = new ArrayList<>();

		String sql = "";

		try {

			sql = sql + "from Dispositivo d";

			if (!nombreDispo.equals(Constantes.TEXTO_VACIO)) {
				sql = sql + " where d.marca like '%" + nombreDispo + "%' ";
			}

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	@Override
	public Map<String, String> registrarDispositivo(String idTrans, Dispositivo d) {

		Map<String, String> out = new HashMap<>();

		try {

			List<Dispositivo> registro = listaDispositivos(idTrans, d.getMarca());

			if (registro.isEmpty()) {

				em.persist(d);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(d.getIdDispositivo()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);

			} else {
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
	public Map<String, String> actualizarDispositivo(String idTrans, Dispositivo d) {
		
		Map<String, String> out = new HashMap<>();

		String sql = "";
		
		try {

			sql = sql + "from Dispositivo d where d.idDispositivo =" + d.getIdDispositivo();
			
			List<Dispositivo> registro = em.createQuery(sql).getResultList();

			if (!registro.isEmpty()) {

				em.merge(d);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(d.getIdDispositivo()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_ACT);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_ACT);

			} else {
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

	@Override
	public Map<String, Object> obtenerDetalleDispositivo(String idTrans, int idDispositivo) {
		
		Map<String, Object> out = new HashMap<>();
		
		String sql = "";
		
		try {
			
			sql = sql + "from Dispositivo d where d.idDispositivo = " + idDispositivo;
			
			Dispositivo dispositivo = new Dispositivo();
			
			List<Dispositivo> lista = em.createQuery(sql).getResultList();
			
			if(!lista.isEmpty()) {
				
				for(int i = 0 ;i < lista.size() ; i++) {
					dispositivo = lista.get(i);
				}
				
				out.put(Constantes.OBJETO_DISPOSITIVO, dispositivo);
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.CODIGO_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.MENSAJE_OK);
				
			}else {
				out.put(Constantes.OBJETO_DISPOSITIVO, dispositivo);
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_NO_ENCONTRADO);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_NO_ENCONTRADO);
			}
			
			
			
		} catch (Exception e) {
			out.put(Constantes.OBJETO_DISPOSITIVO, new Dispositivo() );
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();
		}
		
		return out;
	
	}

	@Override
	public List<DispositivoUsuario> obtenerDispositivoVinculado(String idTrans, int idUsuario) {
		
		List<DispositivoUsuario> lista = new ArrayList<>();
		
		try {
			
			String sql = "from DispositivoUsuario du where du.usuarioUbicacion.usuario.idUsuario = "
					+ idUsuario ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}

}
