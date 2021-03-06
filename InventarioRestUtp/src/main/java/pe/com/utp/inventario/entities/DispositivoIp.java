package pe.com.utp.inventario.entities;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DispositivoIp generated by hbm2java
 */
@Entity
@Table(name = "dispositivo_ip")
public class DispositivoIp implements java.io.Serializable {

	private Integer idIp;
	private Condicion condicion;
	private RecursoDispositivo recursoDispositivo;
	private String ip;
	private String principal;

	public DispositivoIp() {
	}

	public DispositivoIp(Condicion condicion, RecursoDispositivo recursoDispositivo, String ip) {
		this.condicion = condicion;
		this.recursoDispositivo = recursoDispositivo;
		this.ip = ip;
	}

	public DispositivoIp(Condicion condicion, RecursoDispositivo recursoDispositivo, String ip, String principal) {
		this.condicion = condicion;
		this.recursoDispositivo = recursoDispositivo;
		this.ip = ip;
		this.principal = principal;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_ip", unique = true, nullable = false)
	public Integer getIdIp() {
		return this.idIp;
	}

	public void setIdIp(Integer idIp) {
		this.idIp = idIp;
	}

	@ManyToOne
	@JoinColumn(name = "condicion", nullable = false)
	public Condicion getCondicion() {
		return this.condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	@ManyToOne
	@JoinColumn(name = "id_rec_dis", nullable = false)
	public RecursoDispositivo getRecursoDispositivo() {
		return this.recursoDispositivo;
	}

	public void setRecursoDispositivo(RecursoDispositivo recursoDispositivo) {
		this.recursoDispositivo = recursoDispositivo;
	}

	@Column(name = "ip", nullable = false, length = 15)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "principal", length = 10)
	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

}
