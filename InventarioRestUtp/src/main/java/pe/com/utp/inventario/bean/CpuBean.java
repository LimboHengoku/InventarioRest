package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class CpuBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idDispositivo;
	private AntivirusBean antivirusBean;
	private DispositivoBean dispositivoBean;
	private String procesador;
	private String nomCpu;
	private List<CpuSoBean> cpuSoBeans = new ArrayList<>();

	public Integer getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(Integer idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public AntivirusBean getAntivirusBean() {
		return antivirusBean;
	}

	public void setAntivirusBean(AntivirusBean antivirusBean) {
		this.antivirusBean = antivirusBean;
	}

	public DispositivoBean getDispositivoBean() {
		return dispositivoBean;
	}

	public void setDispositivoBean(DispositivoBean dispositivoBean) {
		this.dispositivoBean = dispositivoBean;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getNomCpu() {
		return nomCpu;
	}

	public void setNomCpu(String nomCpu) {
		this.nomCpu = nomCpu;
	}

	public List<CpuSoBean> getCpuSoBeans() {
		return cpuSoBeans;
	}

	public void setCpuSoBeans(List<CpuSoBean> cpuSoBeans) {
		this.cpuSoBeans = cpuSoBeans;
	}

}
