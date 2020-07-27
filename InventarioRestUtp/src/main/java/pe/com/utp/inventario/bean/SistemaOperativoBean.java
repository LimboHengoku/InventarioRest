package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class SistemaOperativoBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idSo;
	private String nomSo;
	private List<CpuSoBean> cpuSoBeans = new ArrayList<CpuSoBean>();

	public Integer getIdSo() {
		return idSo;
	}

	public void setIdSo(Integer idSo) {
		this.idSo = idSo;
	}

	public String getNomSo() {
		return nomSo;
	}

	public void setNomSo(String nomSo) {
		this.nomSo = nomSo;
	}

	public List<CpuSoBean> getCpuSoBeans() {
		return cpuSoBeans;
	}

	public void setCpuSoBeans(List<CpuSoBean> cpuSoBeans) {
		this.cpuSoBeans = cpuSoBeans;
	}

}
