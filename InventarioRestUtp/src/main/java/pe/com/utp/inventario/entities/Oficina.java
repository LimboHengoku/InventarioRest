package pe.com.utp.inventario.entities;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Oficina generated by hbm2java
 */
@Entity
@Table(name = "oficina")
public class Oficina implements java.io.Serializable {

	private Integer idOficina;
	private String nomOficina;
	private List<Ubicacion> ubicacions = new ArrayList<>();

	public Oficina() {
	}

	public Oficina(String nomOficina) {
		this.nomOficina = nomOficina;
	}

	public Oficina(String nomOficina, List<Ubicacion> ubicacions) {
		this.nomOficina = nomOficina;
		this.ubicacions = ubicacions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_oficina", unique = true, nullable = false)
	public Integer getIdOficina() {
		return this.idOficina;
	}

	public void setIdOficina(Integer idOficina) {
		this.idOficina = idOficina;
	}

	@Column(name = "nom_oficina", nullable = false, length = 250)
	public String getNomOficina() {
		return this.nomOficina;
	}

	public void setNomOficina(String nomOficina) {
		this.nomOficina = nomOficina;
	}

	@OneToMany( mappedBy = "oficina")
	public List<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(List<Ubicacion> ubicacions) {
		this.ubicacions = ubicacions;
	}

}
