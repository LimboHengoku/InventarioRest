package pe.com.utp.inventario.request;

public class RegistrarUsuarioUbicacionRequest {

	private int idCondicion;
	private int idDominio;
	private int idUbicacion;
	private int idUsuario;

	public int getIdCondicion() {
		return idCondicion;
	}

	public void setIdCondicion(int idCondicion) {
		this.idCondicion = idCondicion;
	}

	public int getIdDominio() {
		return idDominio;
	}

	public void setIdDominio(int idDominio) {
		this.idDominio = idDominio;
	}

	public int getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
