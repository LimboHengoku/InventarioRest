package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

public class ProveedorBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idProveedor;
	private String nomProveedor;
	private String observacion;
	private String tipoDocumento;
	private String nroDocumento;

	private List<ServicioBean> serviciosForIdPartner = new ArrayList<ServicioBean>(0);
	private List<ServicioBean> serviciosForIdProveedor = new ArrayList<ServicioBean>(0);

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<ServicioBean> getServiciosForIdPartner() {
		return serviciosForIdPartner;
	}

	public void setServiciosForIdPartner(List<ServicioBean> serviciosForIdPartner) {
		this.serviciosForIdPartner = serviciosForIdPartner;
	}

	public List<ServicioBean> getServiciosForIdProveedor() {
		return serviciosForIdProveedor;
	}

	public void setServiciosForIdProveedor(List<ServicioBean> serviciosForIdProveedor) {
		this.serviciosForIdProveedor = serviciosForIdProveedor;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

}
