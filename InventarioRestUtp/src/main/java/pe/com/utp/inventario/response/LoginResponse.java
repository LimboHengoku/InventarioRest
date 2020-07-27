package pe.com.utp.inventario.response;

import pe.com.utp.inventario.bean.LogueoBean;

public class LoginResponse extends GenericoResponse {

	private LogueoBean login;

	public LogueoBean getLogin() {
		return login;
	}

	public void setLogin(LogueoBean login) {
		this.login = login;
	}

}
