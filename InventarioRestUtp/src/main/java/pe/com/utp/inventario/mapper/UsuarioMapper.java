package pe.com.utp.inventario.mapper;

import java.util.Date;

import pe.com.utp.inventario.bean.UsuarioUbicacionBean;

public class UsuarioMapper {
	private Integer idUsuario;
	private String nombres;
	private String ape1;
	private String ape2;
	private String usuRed;
	private Date fecMod;
	private UsuarioUbicacionBean usuarioUbicacion;
	private String estado;

	private int idDivision;
	private int idOficina;
	private int idSede;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getUsuRed() {
		return usuRed;
	}

	public void setUsuRed(String usuRed) {
		this.usuRed = usuRed;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public UsuarioUbicacionBean getUsuarioUbicacion() {
		return usuarioUbicacion;
	}

	public void setUsuarioUbicacion(UsuarioUbicacionBean usuarioUbicacion) {
		this.usuarioUbicacion = usuarioUbicacion;
	}

	public int getIdDivision() {
		return idDivision;
	}

	public void setIdDivision(int idDivision) {
		this.idDivision = idDivision;
	}

	public int getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(int idOficina) {
		this.idOficina = idOficina;
	}

	public int getIdSede() {
		return idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
