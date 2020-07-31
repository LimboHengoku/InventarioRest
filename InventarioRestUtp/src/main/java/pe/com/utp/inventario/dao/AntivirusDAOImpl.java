package pe.com.utp.inventario.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.utp.inventario.entities.Antivirus;
import pe.com.utp.inventario.entities.Dispositivo;
import pe.com.utp.inventario.entities.SistemaOperativo;
import pe.com.utp.inventario.util.Constantes;

@Repository(value = "antivirusDAO")
@SuppressWarnings("unchecked")
@Transactional
public class AntivirusDAOImpl implements AntivirusDAO {

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

	@Override
	public List<SistemaOperativo> listarSO() {
		List<SistemaOperativo> lista = new ArrayList<>();

		String sql = "";

		try {

			sql = sql + "from SistemaOperativo so";

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Map<String, String> registrarAntivirus(Antivirus a) {

		Map<String, String> out = new HashMap<>();

		String sql = "";

		try {

			sql = "from Antivirus a where a.marca like '%" + a.getMarca() + "%'";

			List<Antivirus> registro = em.createQuery(sql).getResultList();

			if (registro.isEmpty()) {

				em.persist(a);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(a.getIdAntivirus()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);

			} else {
				out.put(Constantes.CODIGO_GENERADO, "0");
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_EXISTE);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_EXISTE);

			}

		} catch (Exception e) {
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();

		}

		return out;

	}

	@Override
	public Map<String, String> registrarSO(SistemaOperativo so) {

		Map<String, String> out = new HashMap<>();

		String sql = "";

		try {

			sql = "from SistemaOperativo so where so.nomSo like '%" + so.getNomSo() + "%'";

			List<SistemaOperativo> registro = em.createQuery(sql).getResultList();

			if (registro.isEmpty()) {

				em.persist(so);
				out.put(Constantes.CODIGO_GENERADO, String.valueOf(so.getIdSo()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);

			} else {
				out.put(Constantes.CODIGO_GENERADO, "0");
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_EXISTE);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_EXISTE);

			}

		} catch (Exception e) {
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();

		}

		return out;

	}

	@Override
	public Map<String, String> actualizarAntivirus(Antivirus a) {
				
		Map<String, String> out = new HashMap<>();

		String sql = "";

		try {

			sql = "from Antivirus a where a.idAntivirus =" + a.getIdAntivirus();

			List<Antivirus> registro = em.createQuery(sql).getResultList();

			if (!registro.isEmpty()) {

				em.merge(a);

				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);

			} else {

				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_NO_ENCONTRADO);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_NO_ENCONTRADO);

			}

		} catch (Exception e) {
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();

		}

		return out;
	}

	@Override
	public Map<String, String> actualizarSO(SistemaOperativo so) {
		Map<String, String> out = new HashMap<>();

		String sql = "";

		try {

			sql = "from SistemaOperativo so where so.idSo = " + so.getIdSo() ;

			List<SistemaOperativo> registro = em.createQuery(sql).getResultList();

			if (!registro.isEmpty()) {

				em.merge(so);
				
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);

			} else {

				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_NO_ENCONTRADO);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_NO_ENCONTRADO);

			}

		} catch (Exception e) {
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();

		}

		return out;
	}

	

}
