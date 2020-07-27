package pe.com.utp.inventario.mapper;

import java.util.Date;

public class TipoYDominioMapper {

	private String flag;
//	private TipoDominioMapperBean tipoDominio;
	private Integer idTipodispositivo;
	private String nomDispositivo;
	private Date fechaRegistro;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getIdTipodispositivo() {
		return idTipodispositivo;
	}

	public void setIdTipodispositivo(Integer idTipodispositivo) {
		this.idTipodispositivo = idTipodispositivo;
	}

	public String getNomDispositivo() {
		return nomDispositivo;
	}

	public void setNomDispositivo(String nomDispositivo) {
		this.nomDispositivo = nomDispositivo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
