package pe.com.utp.inventario.mapper;

import java.util.Date;

public class AntivirusAndSOMapper {

	private int idRecurso;
	private String nombreRecurso;
	private Date fechaRegistro;
	private String estado;
	private String flag;

	public int getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
