package pe.com.utp.inventario.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.utp.inventario.bean.AntivirusBean;
import pe.com.utp.inventario.bean.CondicionBean;
import pe.com.utp.inventario.bean.CpuBean;
import pe.com.utp.inventario.bean.DispositivoBean;
import pe.com.utp.inventario.bean.DispositivoUsuarioBean;
import pe.com.utp.inventario.bean.DivisionBean;
import pe.com.utp.inventario.bean.DominioBean;
import pe.com.utp.inventario.bean.EstadoBean;
import pe.com.utp.inventario.bean.OficinaBean;
import pe.com.utp.inventario.bean.SedeBean;
import pe.com.utp.inventario.bean.TipoDispositivoBean;
import pe.com.utp.inventario.bean.UbicacionBean;
import pe.com.utp.inventario.bean.UsuarioBean;
import pe.com.utp.inventario.bean.UsuarioUbicacionBean;
import pe.com.utp.inventario.entities.Condicion;
import pe.com.utp.inventario.entities.DispositivoUsuario;
import pe.com.utp.inventario.entities.Dominio;
import pe.com.utp.inventario.entities.Logueo;
import pe.com.utp.inventario.entities.Ubicacion;
import pe.com.utp.inventario.entities.Usuario;
import pe.com.utp.inventario.entities.UsuarioUbicacion;
import pe.com.utp.inventario.response.ListaUsuarioResponse;
import pe.com.utp.inventario.util.Constantes;

@Repository(value = "usuarioDAO")
@EntityScan(basePackages = "pe.com.utp.inventario.entities")
@Transactional(propagation = Propagation.NESTED)
public class UsuarioDAOImpl implements UsuarioDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public ListaUsuarioResponse listarUsuarios() {

		ListaUsuarioResponse response = new ListaUsuarioResponse();
		List<UsuarioBean> lista = new ArrayList<>();
		String sql = "";

		try {

			sql = sql + "From Usuario u";

			List<Usuario> usuarios = em.createQuery(sql).getResultList();

			if (!usuarios.isEmpty()) {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_EXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_EXITOSO);

				for (Usuario u : usuarios) {
					UsuarioBean bean = new UsuarioBean();
					bean.setIdUsuario(u.getIdUsuario());
					bean.setNombres(u.getNombres());
					bean.setApe1(u.getApe1());
					bean.setApe2(u.getApe2());
					bean.setUsuRed(u.getUsuRed());
					bean.setEstado(u.getEstado());

					if (!u.getUsuarioUbicacions().isEmpty()) {

						List<UsuarioUbicacionBean> listaUbiUsu = new ArrayList<>();
						

						for (UsuarioUbicacion ub : u.getUsuarioUbicacions()) {
							
							List<DispositivoUsuarioBean> listaDispoUsu = new ArrayList<>();

							UsuarioUbicacionBean ubBean = new UsuarioUbicacionBean();
							ubBean.setIdUsuUbi(ub.getIdUsuUbi());

							UbicacionBean ubiBean = new UbicacionBean();

							if (ub.getUbicacion() != null) {

								ubiBean.setIdUbicacion(ub.getUbicacion().getIdUbicacion());

								SedeBean sBean = new SedeBean();
								DivisionBean dBean = new DivisionBean();
								OficinaBean oBean = new OficinaBean();

								if (ub.getUbicacion().getSede() != null) {
									sBean.setIdSede(ub.getUbicacion().getSede().getIdSede());
									sBean.setNomSede(ub.getUbicacion().getSede().getNomSede());
								}

								if (ub.getUbicacion().getDivision() != null) {
									dBean.setIdDivision(ub.getUbicacion().getDivision().getIdDivision());
									dBean.setNomDivision(ub.getUbicacion().getDivision().getNomDivision());
								}

								if (ub.getUbicacion().getOficina() != null) {
									oBean.setIdOficina(ub.getUbicacion().getOficina().getIdOficina());
									oBean.setNomOficina(ub.getUbicacion().getOficina().getNomOficina());
								}

								ubiBean.setSedeBean(sBean);
								ubiBean.setDivisionBean(dBean);
								ubiBean.setOficinaBean(oBean);
							}

							CondicionBean condicionBean = new CondicionBean();
							condicionBean.setIdCondicion(ub.getCondicion().getIdCondicion());
							condicionBean.setNomCondicion(ub.getCondicion().getNomCondicion());

							DominioBean dominioBean = new DominioBean();
							dominioBean.setIdDominio(ub.getDominio().getIdDominio());
							dominioBean.setNomDominio(ub.getDominio().getNomDominio());
							
							if(!ub.getDispositivoUsuarios().isEmpty()) {

								for(DispositivoUsuario du : ub.getDispositivoUsuarios()) {
									DispositivoUsuarioBean duBean = new DispositivoUsuarioBean();
									duBean.setIdDisUsu(du.getIdDisUsu());
									
									TipoDispositivoBean tipoDispoBean = new TipoDispositivoBean();
									tipoDispoBean.setIdTipodispositivo(du.getDispositivo().getTipoDispositivo().getIdTipodispositivo());
									tipoDispoBean.setNomDispositivo(du.getDispositivo().getTipoDispositivo().getNomDispositivo());
									
									EstadoBean estadoBean = new EstadoBean();
									estadoBean.setIdEstado(du.getDispositivo().getEstado().getIdEstado());
									estadoBean.setNomEstado(du.getDispositivo().getEstado().getNomEstado());
									
									DispositivoBean dispoBean = new DispositivoBean();
									dispoBean.setIdDispositivo(du.getDispositivo().getIdDispositivo());
									dispoBean.setTipoDispositivoBean(tipoDispoBean);
									dispoBean.setEstadoBean(estadoBean);
									dispoBean.setMarca(du.getDispositivo().getMarca());
									dispoBean.setModelo(du.getDispositivo().getModelo());
									dispoBean.setSerie(du.getDispositivo().getSerie());
									dispoBean.setCodBarras(du.getDispositivo().getCodBarras());
									dispoBean.setObservacion(du.getDispositivo().getObservacion());
									dispoBean.setFecMod(du.getDispositivo().getFecMod());
									
									CpuBean cpBean = new CpuBean();
									cpBean.setIdDispositivo(du.getDispositivo().getCpu().getIdDispositivo());
									cpBean.setProcesador(du.getDispositivo().getCpu().getProcesador());
									cpBean.setNomCpu(du.getDispositivo().getCpu().getNomCpu());
									
									AntivirusBean aBean = new AntivirusBean();
									aBean.setIdAntivirus(du.getDispositivo().getCpu().getAntivirus().getIdAntivirus());
									aBean.setMarca(du.getDispositivo().getCpu().getAntivirus().getMarca());
									
									cpBean.setAntivirusBean(aBean);
									dispoBean.setCpuBean(cpBean);
									duBean.setDispositivoBean(dispoBean);
									
									listaDispoUsu.add(duBean);
								}
								
							}
							

							ubBean.setCondicionBean(condicionBean);
							ubBean.setDominioBean(dominioBean);

							ubBean.setUbicacionBean(ubiBean);
							ubBean.setDispositivoUsuarioBeans(listaDispoUsu);
							
							listaUbiUsu.add(ubBean);
							bean.setUsuarioUbicacionBeans(listaUbiUsu);
						}

					}

					lista.add(bean);
				}

			} else {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_NOEXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_NOEXITOSO);
			}

			response.setUsuarios(lista);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Logueo login(String idTransaccion, String usuario, String clave) {

		Logueo user = new Logueo();

		String sql = "";

		try {

			if (!usuario.equals(Constantes.TEXTO_VACIO) && !clave.equals(Constantes.TEXTO_VACIO)) {
				sql = sql + "from Logueo l where l.user = '" + usuario + "' and l.pass = '" + clave + "' ";
			} else {
				sql = sql + "from Logueo l where l.user = '" + usuario + "' ";
			}

			List<Logueo> registro = em.createQuery(sql).getResultList();

			if (!registro.isEmpty()) {

				for (Logueo u : registro) {
					user = u;
				}

			} else {
				user = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

	@Override
	public Map<String, String> registrarUsuario(String idTransaccion, Usuario u) {

		Map<String, String> out = new HashMap<>();

		try {

			String sql = "from Usuario x where x.usuRed ='" + u.getUsuRed() + "'";

			List<Usuario> reg = em.createQuery(sql).getResultList();

			System.out.println("reg usuario : " + reg.size());

			if (reg.isEmpty()) {

				em.persist(u);

				out.put(Constantes.CODIGO_GENERADO, String.valueOf(u.getIdUsuario()));
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
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + " : " + e);
		}

		return out;

	}

	@Override
	public Map<String, String> registrarUbicacionUsuario(String idTransaccion, Map<String, String> params) {

		Map<String, String> out = new HashMap<>();

		try {

			UsuarioUbicacion ub = new UsuarioUbicacion();

			Condicion condicion = new Condicion();
			condicion.setIdCondicion(Integer.valueOf(params.get(Constantes.ID_CONDICION).toString()));

			Dominio dominio = new Dominio();
			dominio.setIdDominio(Integer.valueOf(params.get(Constantes.ID_DOMINIO).toString()));

			Ubicacion ubicacion = new Ubicacion();
			ubicacion.setIdUbicacion(Integer.valueOf(params.get(Constantes.ID_UBICACION).toString()));

			Usuario usuario = new Usuario();
			usuario.setIdUsuario(Integer.valueOf(params.get(Constantes.ID_USUARIO).toString()));

			ub.setCondicion(condicion);
			ub.setDominio(dominio);
			ub.setUbicacion(ubicacion);
			ub.setUsuario(usuario);
			ub.setFecMod(new Date());

//			if(!params.get(Constantes.ID_USUARIO_UBI).toString().equals(Constantes.TEXTO_VACIO)) {
//			ub.setIdUsuUbi(Integer.valueOf(params.get(Constantes.ID_USUARIO_UBI).toString()));
//			}

//			if(!params.get(Constantes.ID_USUARIO_UBI).toString().equals(Constantes.TEXTO_VACIO)) {
			em.persist(ub);
//			}else {
//				em.merge(ub);
//			}

			out.put(Constantes.CODIGO_GENERADO, String.valueOf(ub.getIdUsuUbi()));
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_OK);
			out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_OK);

		} catch (Exception e) {
			out.put(Constantes.CODIGO_GENERADO, "0");
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + " : " + e);
			e.printStackTrace();
		}

		return out;

	}

	@Override
	public Map<String, String> actualizarUsuario(String idTransaccion, Usuario u) {

		Map<String, String> out = new HashMap<>();
		
		try {

			String sql = "from Usuario u where u.idUsuario = " + u.getIdUsuario();
			
			List<Usuario> reg = em.createQuery(sql).getResultList();
			
			if(!reg.isEmpty()) {

				em.merge(u);

				out.put(Constantes.CODIGO_GENERADO, String.valueOf(u.getIdUsuario()));
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_ACT);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_ACT);

			}else {

				out.put(Constantes.CODIGO_GENERADO, "0");
				out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_REG_NO_ENCONTRADO);
				out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_REG_NO_ENCONTRADO);
				
			}
			
		} catch (Exception e) {
			out.put(Constantes.CODIGO_GENERADO, "0");
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + " : " + e);
			e.printStackTrace();
		}

		return out;
	}

}
