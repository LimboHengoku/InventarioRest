package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1
 

public class DispositivoIpBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idIp;
	private CondicionBean condicionBean;
	private RecursoDispositivoBean recursoDispositivoBean;
	private String ip;
	private String principal;

	public Integer getIdIp() {
		return idIp;
	}

	public void setIdIp(Integer idIp) {
		this.idIp = idIp;
	}

	public CondicionBean getCondicionBean() {
		return condicionBean;
	}

	public void setCondicionBean(CondicionBean condicionBean) {
		this.condicionBean = condicionBean;
	}

	public RecursoDispositivoBean getRecursoDispositivoBean() {
		return recursoDispositivoBean;
	}

	public void setRecursoDispositivoBean(RecursoDispositivoBean recursoDispositivoBean) {
		this.recursoDispositivoBean = recursoDispositivoBean;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

}
