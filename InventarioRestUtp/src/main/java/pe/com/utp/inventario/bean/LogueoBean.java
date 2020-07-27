package pe.com.utp.inventario.bean;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

public class LogueoBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idLogueo;
	private TipoLogueoBean tipoLogueoBean;
	private UsuarioBean usuarioBean;
	private String user;
	private String pass;
	private int sesiones;

	public Integer getIdLogueo() {
		return idLogueo;
	}

	public void setIdLogueo(Integer idLogueo) {
		this.idLogueo = idLogueo;
	}

	public TipoLogueoBean getTipoLogueoBean() {
		return tipoLogueoBean;
	}

	public void setTipoLogueoBean(TipoLogueoBean tipoLogueoBean) {
		this.tipoLogueoBean = tipoLogueoBean;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getSesiones() {
		return sesiones;
	}

	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}

}
