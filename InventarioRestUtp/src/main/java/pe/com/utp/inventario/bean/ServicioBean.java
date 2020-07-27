package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.Date;

public class ServicioBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idServicio;
	private CondicionBean condicionBean;
	private ProveedorBean proveedorByIdPartner;
	private ProveedorBean proveedorByIdProveedor;
	private SoftwareBean softwareBean;
	private TipoLicenciaBean tipoLicenciaBean;
	private UbicacionBean ubicacionBean;
	private Date fecInicio;
	private Date fecExpiracion;
	private String orden;
	private String observacion;
	private String renovacion;

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public CondicionBean getCondicionBean() {
		return condicionBean;
	}

	public void setCondicionBean(CondicionBean condicionBean) {
		this.condicionBean = condicionBean;
	}

	public ProveedorBean getProveedorByIdPartner() {
		return proveedorByIdPartner;
	}

	public void setProveedorByIdPartner(ProveedorBean proveedorByIdPartner) {
		this.proveedorByIdPartner = proveedorByIdPartner;
	}

	public ProveedorBean getProveedorByIdProveedor() {
		return proveedorByIdProveedor;
	}

	public void setProveedorByIdProveedor(ProveedorBean proveedorByIdProveedor) {
		this.proveedorByIdProveedor = proveedorByIdProveedor;
	}

	public SoftwareBean getSoftwareBean() {
		return softwareBean;
	}

	public void setSoftwareBean(SoftwareBean softwareBean) {
		this.softwareBean = softwareBean;
	}

	public TipoLicenciaBean getTipoLicenciaBean() {
		return tipoLicenciaBean;
	}

	public void setTipoLicenciaBean(TipoLicenciaBean tipoLicenciaBean) {
		this.tipoLicenciaBean = tipoLicenciaBean;
	}

	public UbicacionBean getUbicacionBean() {
		return ubicacionBean;
	}

	public void setUbicacionBean(UbicacionBean ubicacionBean) {
		this.ubicacionBean = ubicacionBean;
	}

	public Date getFecInicio() {
		return fecInicio;
	}

	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	public Date getFecExpiracion() {
		return fecExpiracion;
	}

	public void setFecExpiracion(Date fecExpiracion) {
		this.fecExpiracion = fecExpiracion;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getRenovacion() {
		return renovacion;
	}

	public void setRenovacion(String renovacion) {
		this.renovacion = renovacion;
	}

}
