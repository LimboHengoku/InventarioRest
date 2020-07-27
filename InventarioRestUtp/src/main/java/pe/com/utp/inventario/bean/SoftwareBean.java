package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1
 

public class SoftwareBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idSoftware;
	private String nomSoftware;
	private String observacion;

	public Integer getIdSoftware() {
		return idSoftware;
	}

	public void setIdSoftware(Integer idSoftware) {
		this.idSoftware = idSoftware;
	}

	public String getNomSoftware() {
		return nomSoftware;
	}

	public void setNomSoftware(String nomSoftware) {
		this.nomSoftware = nomSoftware;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
