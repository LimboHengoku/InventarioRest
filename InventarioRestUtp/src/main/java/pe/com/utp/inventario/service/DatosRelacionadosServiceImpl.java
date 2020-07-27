package pe.com.utp.inventario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.utp.inventario.bean.AntivirusBean;
import pe.com.utp.inventario.bean.CpuBean;
import pe.com.utp.inventario.dao.AntivirusDAO;
import pe.com.utp.inventario.dao.CpuDAO;
import pe.com.utp.inventario.entities.Antivirus;
import pe.com.utp.inventario.entities.Cpu;
import pe.com.utp.inventario.response.ListarAntivirusResponse;
import pe.com.utp.inventario.response.ListarProcesadoresResponse;
import pe.com.utp.inventario.util.Constantes;

@Service(value = "datosRelacionadosService")
public class DatosRelacionadosServiceImpl implements DatosRelacionadosService{
	
	@Autowired
	private AntivirusDAO antivirusDAO;
	
	@Autowired	
	private CpuDAO cpuDAO;

	@Override
	public ListarAntivirusResponse listarAntivirus() {
		
		ListarAntivirusResponse response = new ListarAntivirusResponse();
		
		List<AntivirusBean> antivirus = new ArrayList<>();
		
		try {
			
			List<Antivirus> result = antivirusDAO.listarAntivirus();
			
			if(!result.isEmpty()) {
				
				for(Antivirus a : result) {
					AntivirusBean bean = new AntivirusBean();
					bean.setIdAntivirus(a.getIdAntivirus());
					bean.setMarca(a.getMarca());
					antivirus.add(bean);
				}

				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);

				
			}else {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_NOEXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_NOEXITOSO);

			}
			
			response.setAntivirus(antivirus);
			
		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public ListarProcesadoresResponse listarProcesadores() {
		
		ListarProcesadoresResponse response = new ListarProcesadoresResponse();
		
		List<CpuBean> procesadores = new ArrayList<>();
		
		try {
			
			List<Cpu> result = cpuDAO.listarProcesador();
			
			if(!result.isEmpty()) {
				
				for(Cpu c : result) {
					CpuBean bean = new CpuBean();
					bean.setIdDispositivo(c.getIdDispositivo());
					bean.setNomCpu(c.getNomCpu());
					bean.setProcesador(c.getProcesador());
					procesadores.add(bean);
				}

				response.setCodigoRespuesta(Constantes.CODIGO_OK);
				response.setMensajeRespuesta(Constantes.MENSAJE_OK);

				
			}else {
				response.setCodigoRespuesta(Constantes.CODIGO_LISTA_NOEXITOSO);
				response.setMensajeRespuesta(Constantes.MENSAJE_LISTA_NOEXITOSO);

			}
			
			response.setProcesadores(procesadores);
			
		} catch (Exception e) {
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("ERROR en : " + e);
			e.printStackTrace();
		}
		
		return response;
	}
	
	

}
