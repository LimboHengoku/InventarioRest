package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class AntivirusBean implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer idAntivirus;
	private String marca;
	private List<CpuBean> cpuBeans = new ArrayList<>();

	public Integer getIdAntivirus() {
		return idAntivirus;
	}

	public void setIdAntivirus(Integer idAntivirus) {
		this.idAntivirus = idAntivirus;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<CpuBean> getCpuBeans() {
		return cpuBeans;
	}

	public void setCpuBeans(List<CpuBean> cpuBeans) {
		this.cpuBeans = cpuBeans;
	}

}
