package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class CpuSoBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idCpuSo;
	private CondicionBean condicionBean;
	private CpuBean cpuBean;
	private SistemaOperativoBean sistemaOperativoBean;
	private Date fecMod;

	public Integer getIdCpuSo() {
		return idCpuSo;
	}

	public void setIdCpuSo(Integer idCpuSo) {
		this.idCpuSo = idCpuSo;
	}

	public CondicionBean getCondicionBean() {
		return condicionBean;
	}

	public void setCondicionBean(CondicionBean condicionBean) {
		this.condicionBean = condicionBean;
	}

	public CpuBean getCpuBean() {
		return cpuBean;
	}

	public void setCpuBean(CpuBean cpuBean) {
		this.cpuBean = cpuBean;
	}

	public SistemaOperativoBean getSistemaOperativoBean() {
		return sistemaOperativoBean;
	}

	public void setSistemaOperativoBean(SistemaOperativoBean sistemaOperativoBean) {
		this.sistemaOperativoBean = sistemaOperativoBean;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

}
