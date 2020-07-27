package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecursoDispositivoBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idRecDis;
	private CondicionBean condicionBean;
	private DispositivoBean dispositivoBean;
	private RecursoBean recursoBean;
	private Date fecMod;
	private List<DispositivoIpBean> dispositivoIpBeans = new ArrayList<DispositivoIpBean>(0);

	public Integer getIdRecDis() {
		return idRecDis;
	}

	public void setIdRecDis(Integer idRecDis) {
		this.idRecDis = idRecDis;
	}

	public CondicionBean getCondicionBean() {
		return condicionBean;
	}

	public void setCondicionBean(CondicionBean condicionBean) {
		this.condicionBean = condicionBean;
	}

	public DispositivoBean getDispositivoBean() {
		return dispositivoBean;
	}

	public void setDispositivoBean(DispositivoBean dispositivoBean) {
		this.dispositivoBean = dispositivoBean;
	}

	public RecursoBean getRecursoBean() {
		return recursoBean;
	}

	public void setRecursoBean(RecursoBean recursoBean) {
		this.recursoBean = recursoBean;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public List<DispositivoIpBean> getDispositivoIpBeans() {
		return dispositivoIpBeans;
	}

	public void setDispositivoIpBeans(List<DispositivoIpBean> dispositivoIpBeans) {
		this.dispositivoIpBeans = dispositivoIpBeans;
	}

}
