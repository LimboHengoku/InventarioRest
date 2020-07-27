package pe.com.utp.inventario.response;

import java.util.List;

import pe.com.utp.inventario.bean.AntivirusBean;

public class ListarAntivirusResponse extends GenericoResponse {

	private List<AntivirusBean> antivirus;

	public List<AntivirusBean> getAntivirus() {
		return antivirus;
	}

	public void setAntivirus(List<AntivirusBean> antivirus) {
		this.antivirus = antivirus;
	}

}
