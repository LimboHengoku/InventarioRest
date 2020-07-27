package pe.com.utp.inventario.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.utp.inventario.bean.AntivirusBean;
import pe.com.utp.inventario.bean.CondicionBean;
import pe.com.utp.inventario.bean.CpuBean;
import pe.com.utp.inventario.bean.CpuSoBean;
import pe.com.utp.inventario.bean.DispositivoBean;
import pe.com.utp.inventario.bean.DispositivoUsuarioBean;
import pe.com.utp.inventario.bean.DivisionBean;
import pe.com.utp.inventario.bean.EstadoBean;
import pe.com.utp.inventario.bean.OficinaBean;
import pe.com.utp.inventario.bean.SedeBean;
import pe.com.utp.inventario.bean.SistemaOperativoBean;
import pe.com.utp.inventario.bean.TipoDispositivoBean;
import pe.com.utp.inventario.bean.UbicacionBean;
import pe.com.utp.inventario.bean.UsuarioBean;
import pe.com.utp.inventario.bean.UsuarioUbicacionBean;
import pe.com.utp.inventario.dao.DispositivoDAO;
import pe.com.utp.inventario.entities.CpuSo;
import pe.com.utp.inventario.entities.Dispositivo;
import pe.com.utp.inventario.entities.DispositivoUsuario;
import pe.com.utp.inventario.entities.Division;
import pe.com.utp.inventario.entities.Estado;
import pe.com.utp.inventario.entities.Oficina;
import pe.com.utp.inventario.entities.Sede;
import pe.com.utp.inventario.entities.TipoDispositivo;
import pe.com.utp.inventario.entities.Ubicacion;
import pe.com.utp.inventario.request.DetalleDispositivoRequest;
import pe.com.utp.inventario.request.ListaDispositivoRequest;
import pe.com.utp.inventario.request.ListaTipoYDominioRequest;
import pe.com.utp.inventario.request.RegistrarDispositivoRequest;
import pe.com.utp.inventario.response.DetalleDispositivoResponse;
import pe.com.utp.inventario.response.GenericoResponse;
import pe.com.utp.inventario.response.ListaDispositivoResponse;
import pe.com.utp.inventario.util.Constantes;

@Service(value = "dispositivoService")
public class DispositivoServiceImpl implements DispositivoService {

	@Autowired
	private DispositivoDAO dispositivoDAO;

	@Override
	public int cantidadDispositivosActivos(String idTrans) {
		return dispositivoDAO.cantidadDispositivosActivos(idTrans);
	}

	@Override
	public ListaDispositivoResponse listarDispositivos(String idTrans, ListaDispositivoRequest params) {

		ListaDispositivoResponse response = new ListaDispositivoResponse();

		List<DispositivoBean> dispositivos = new ArrayList<>();

		try {

			List<Dispositivo> lista = dispositivoDAO.listaDispositivos(idTrans, params.getNombreDispo());

			if (!lista.isEmpty()) {

				for (Dispositivo d : lista) {
					DispositivoBean bean = new DispositivoBean();
					bean.setIdDispositivo(d.getIdDispositivo());

					EstadoBean eBean = new EstadoBean();

					if (d.getEstado() != null) {
						eBean.setIdEstado(d.getEstado().getIdEstado());
						eBean.setNomEstado(d.getEstado().getNomEstado());
					}

					TipoDispositivoBean tBean = new TipoDispositivoBean();

					if (d.getTipoDispositivo() != null) {
						tBean.setIdTipodispositivo(d.getTipoDispositivo().getIdTipodispositivo());
						tBean.setNomDispositivo(d.getTipoDispositivo().getNomDispositivo());
					}

					UbicacionBean uBean = new UbicacionBean();

					DivisionBean dBean = new DivisionBean();

					OficinaBean oBean = new OficinaBean();

					SedeBean sBean = new SedeBean();
					

					if (d.getUbicacion() != null) {

						uBean.setIdUbicacion(d.getUbicacion().getIdUbicacion());

						dBean.setIdDivision(d.getUbicacion().getDivision().getIdDivision());
						dBean.setNomDivision(d.getUbicacion().getDivision().getNomDivision());

						oBean.setIdOficina(d.getUbicacion().getOficina().getIdOficina());
						oBean.setNomOficina(d.getUbicacion().getOficina().getNomOficina());

						sBean.setIdSede(d.getUbicacion().getSede().getIdSede());
						sBean.setNomSede(d.getUbicacion().getSede().getNomSede());
					}

					uBean.setDivisionBean(dBean);
					uBean.setOficinaBean(oBean);
					uBean.setSedeBean(sBean);
					
					List<DispositivoUsuarioBean> listDuBean = new ArrayList<>();
					
//					if(!d.getDispositivoUsuarios().isEmpty()) {
						
						for(DispositivoUsuario du : d.getDispositivoUsuarios()) {
							
							DispositivoUsuarioBean dubean = new DispositivoUsuarioBean();
							dubean.setIdDisUsu(du.getIdDisUsu());
							
							if(du.getUsuarioUbicacion()!=null) {
								UsuarioUbicacionBean uUBean = new UsuarioUbicacionBean();
								
								uUBean.setIdUsuUbi(du.getUsuarioUbicacion().getIdUsuUbi());
								
								if(du.getUsuarioUbicacion()
										.getUsuario()!=null) {
									UsuarioBean usuBean = new UsuarioBean();
									
									usuBean.setIdUsuario(du.getUsuarioUbicacion()
											.getUsuario().getIdUsuario());
									usuBean.setNombres(du.getUsuarioUbicacion()
											.getUsuario().getNombres());
									usuBean.setApe1(du.getUsuarioUbicacion()
											.getUsuario().getApe1());
									usuBean.setApe2(du.getUsuarioUbicacion()
											.getUsuario().getApe2());
									usuBean.setUsuRed(du.getUsuarioUbicacion()
											.getUsuario().getUsuRed());
									
									uUBean.setUsuarioBean(usuBean);
								}
								
								dubean.setUsuarioUbicacionBean(uUBean);
								
							}
							
							dubean.setFecMod(du.getFecMod());
							dubean.setObservacion(du.getObservacion());
														
							listDuBean.add(dubean);
						}
						
//					}

					CpuBean cBean = new CpuBean();
					
					if(d.getCpu()!=null) {
						
						cBean.setIdDispositivo(d.getCpu().getIdDispositivo());
						
						AntivirusBean aBean = new AntivirusBean();
						
						if(d.getCpu().getAntivirus()!=null) {
							aBean.setIdAntivirus(d.getCpu().getAntivirus().getIdAntivirus());
							aBean.setMarca(d.getCpu().getAntivirus().getMarca());
							cBean.setAntivirusBean(aBean);
						}
						
						cBean.setProcesador(d.getCpu().getProcesador());
						cBean.setNomCpu(d.getCpu().getNomCpu());
						
						List<CpuSoBean> listaSO = new ArrayList<>();
						
						for(CpuSo cpuso : d.getCpu().getCpuSos()) {
							CpuSoBean cpusoBean = new CpuSoBean();
							cpusoBean.setIdCpuSo(cpuso.getIdCpuSo());
							
							SistemaOperativoBean soBean = new SistemaOperativoBean();
							soBean.setIdSo(cpuso.getSistemaOperativo().getIdSo());
							soBean.setNomSo(cpuso.getSistemaOperativo().getNomSo());
							cpusoBean.setSistemaOperativoBean(soBean);
							listaSO.add(cpusoBean);
						}
						
						cBean.setCpuSoBeans(listaSO);
						
					}
					
					bean.setEstadoBean(eBean);
					bean.setTipoDispositivoBean(tBean);
					bean.setUbicacionBean(uBean);
					bean.setMarca(d.getMarca());
					bean.setCodBarras(d.getCodBarras());
					bean.setModelo(d.getModelo());
					bean.setSerie(d.getSerie());
					bean.setObservacion(d.getObservacion());
					bean.setIdDispasoc(d.getIdDispasoc());
					bean.setFecMod(d.getFecMod());
					bean.setFecReg(d.getFechReg());
					bean.setUrlImagen(d.getUrImagen());
					bean.setDispositivoUsuarioBeans(listDuBean);
					bean.setCpuBean(cBean);
					dispositivos.add(bean);

				}

				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);

			} else {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_NOEXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_NOEXITOSO);

			}

			response.setDispositivos(dispositivos);

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}

		return response;

	}

	@Override
	public GenericoResponse registrarDispositivo(String idTrans, RegistrarDispositivoRequest params) {

		GenericoResponse response = new GenericoResponse();

		try {
			
			Dispositivo dispo = new Dispositivo();

			Estado eBean = new Estado();

			if (params.getDispositivo().getEstadoBean() != null) {
				eBean.setIdEstado(params.getDispositivo().getEstadoBean().getIdEstado());
//				eBean.setNomEstado(params.getDispositivo().getEstadoBean().getNomEstado());
			}

			TipoDispositivo tBean = new TipoDispositivo();

			if (params.getDispositivo().getTipoDispositivoBean() != null) {
				tBean.setIdTipodispositivo(params.getDispositivo().getTipoDispositivoBean().getIdTipodispositivo());
//				tBean.setNomDispositivo((params.getDispositivo().getTipoDispositivoBean().getNomDispositivo()));
			}

			Ubicacion uBean = new Ubicacion();

			if (params.getDispositivo().getUbicacionBean() != null) {

				uBean.setIdUbicacion(params.getDispositivo().getUbicacionBean().getIdUbicacion());
			}

			dispo.setEstado(eBean);
			dispo.setTipoDispositivo(tBean);
			dispo.setUbicacion(uBean);
			dispo.setMarca(params.getDispositivo().getMarca());
			dispo.setCodBarras(params.getDispositivo().getCodBarras());
			dispo.setModelo(params.getDispositivo().getModelo());
			dispo.setSerie(params.getDispositivo().getSerie());
			dispo.setObservacion(params.getDispositivo().getObservacion());
			dispo.setIdDispasoc(params.getDispositivo().getIdDispasoc());
			dispo.setFechReg(new Date());
			
			dispo.setUrImagen(params.getDispositivo().getUrlImagen());
			
			Map<String,String> out = dispositivoDAO.registrarDispositivo(idTrans, dispo);
			
			response.setCodigoRespuesta(out.get(Constantes.CODIGO_RESPUESTA).toString());
			response.setMensajeRespuesta(out.get(Constantes.MENSAJE_RESPUESTA).toString());
			

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public GenericoResponse actualizarDispositivo(String idTrans, RegistrarDispositivoRequest params) {
		GenericoResponse response = new GenericoResponse();

		try {
			
			Dispositivo dispo = new Dispositivo();

			dispo.setIdDispositivo(params.getDispositivo().getIdDispositivo());

			Estado eBean = new Estado();

			if (params.getDispositivo().getEstadoBean() != null) {
				eBean.setIdEstado(params.getDispositivo().getEstadoBean().getIdEstado()); 
			}

			TipoDispositivo tBean = new TipoDispositivo();

			if (params.getDispositivo().getTipoDispositivoBean() != null) {
				tBean.setIdTipodispositivo(params.getDispositivo().getTipoDispositivoBean().getIdTipodispositivo()); 
			}

			Ubicacion uBean = new Ubicacion();  

			if (params.getDispositivo().getUbicacionBean() != null) {

				uBean.setIdUbicacion(params.getDispositivo().getUbicacionBean().getIdUbicacion()); 
			}
 

			dispo.setEstado(eBean);
			dispo.setTipoDispositivo(tBean);
			dispo.setUbicacion(uBean);
			dispo.setMarca(params.getDispositivo().getMarca());
			dispo.setCodBarras(params.getDispositivo().getCodBarras());
			dispo.setModelo(params.getDispositivo().getModelo());
			dispo.setSerie(params.getDispositivo().getSerie());
			dispo.setObservacion(params.getDispositivo().getObservacion());
			dispo.setIdDispasoc(params.getDispositivo().getIdDispasoc());
			dispo.setFecMod(new Date());
			
			dispo.setUrImagen(params.getDispositivo().getUrlImagen());
			
			Map<String,String> out = dispositivoDAO.actualizarDispositivo(idTrans, dispo);
			
			response.setCodigoRespuesta(out.get(Constantes.CODIGO_RESPUESTA).toString());
			response.setMensajeRespuesta(out.get(Constantes.MENSAJE_RESPUESTA).toString());

		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public DetalleDispositivoResponse obtenerDetalleDispositivo(String idTrans,
				DetalleDispositivoRequest params) {
		
		DetalleDispositivoResponse response = new DetalleDispositivoResponse();
		 
		try {
			
			Map<String,Object> result = dispositivoDAO.obtenerDetalleDispositivo(idTrans, 
					params.getIdDispositivo());
			
			Dispositivo dispositivo = (Dispositivo) result.get(Constantes.OBJETO_DISPOSITIVO); 
			
			DispositivoBean dBean = new DispositivoBean();
			
			dBean.setIdDispositivo(dispositivo.getIdDispositivo());

			EstadoBean eBean = new EstadoBean();

			if (dispositivo.getEstado() != null) {
				eBean.setIdEstado(dispositivo.getEstado().getIdEstado()); 
				eBean.setNomEstado(dispositivo.getEstado().getNomEstado());
			}

			TipoDispositivoBean tBean = new TipoDispositivoBean();

			if (dispositivo.getTipoDispositivo() != null) {
				tBean.setIdTipodispositivo(dispositivo.getTipoDispositivo()
						.getIdTipodispositivo()); 
				tBean.setNomDispositivo(dispositivo.getTipoDispositivo()
						.getNomDispositivo());
			}

			UbicacionBean uBean = new UbicacionBean();  

			if (dispositivo.getUbicacion() != null) {

				uBean.setIdUbicacion(dispositivo.getUbicacion().getIdUbicacion()); 
			}
			
			DivisionBean divBean = new DivisionBean();
			OficinaBean oBean = new OficinaBean();
			SedeBean sBean = new SedeBean();
			
			if(dispositivo.getUbicacion().getDivision() !=null) {
				divBean.setIdDivision(dispositivo.getUbicacion().getDivision().getIdDivision());
				divBean.setNomDivision(dispositivo.getUbicacion().getDivision().getNomDivision());
			}
			
			if(dispositivo.getUbicacion().getOficina() !=null) {
				oBean.setIdOficina(dispositivo.getUbicacion().getOficina().getIdOficina());
				oBean.setNomOficina(dispositivo.getUbicacion().getOficina().getNomOficina());
			}
			
			if(dispositivo.getUbicacion().getSede() !=null) {
				sBean.setIdSede(dispositivo.getUbicacion().getSede().getIdSede());
				sBean.setNomSede(dispositivo.getUbicacion().getSede().getNomSede());
			}
			
			uBean.setDivisionBean(divBean);
			uBean.setOficinaBean(oBean);
			uBean.setSedeBean(sBean);

			dBean.setEstadoBean(eBean);
			dBean.setTipoDispositivoBean(tBean);
			dBean.setUbicacionBean(uBean);
			dBean.setMarca(dispositivo.getMarca());
			dBean.setCodBarras(dispositivo.getCodBarras());
			dBean.setModelo(dispositivo.getModelo());
			dBean.setSerie(dispositivo.getSerie());
			dBean.setObservacion(dispositivo.getObservacion());
			dBean.setIdDispasoc(dispositivo.getIdDispasoc());
			dBean.setFecMod(dispositivo.getFecMod());
			dBean.setFecReg(dispositivo.getFechReg());
			
			dBean.setUrlImagen(dispositivo.getUrImagen());
			
			response.setDispositivo(dBean);
			response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
			response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());
			
			
		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}
		
		return response;
	}

}
