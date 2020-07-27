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
 * SistemaOperativo generated by hbm2java
 */
@Entity
@Table(name = "sistema_operativo", catalog = "inventario")
public class SistemaOperativo implements java.io.Serializable {

	private Integer idSo;
	private String nomSo;
	private List<CpuSo> cpuSos = new ArrayList<CpuSo>();

	public SistemaOperativo() {
	}

	public SistemaOperativo(String nomSo) {
		this.nomSo = nomSo;
	}

	public SistemaOperativo(String nomSo, List<CpuSo> cpuSos) {
		this.nomSo = nomSo;
		this.cpuSos = cpuSos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_so", unique = true, nullable = false)
	public Integer getIdSo() {
		return this.idSo;
	}

	public void setIdSo(Integer idSo) {
		this.idSo = idSo;
	}

	@Column(name = "nom_so", nullable = false, length = 250)
	public String getNomSo() {
		return this.nomSo;
	}

	public void setNomSo(String nomSo) {
		this.nomSo = nomSo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sistemaOperativo")
	public List<CpuSo> getCpuSos() {
		return this.cpuSos;
	}

	public void setCpuSos(List<CpuSo> cpuSos) {
		this.cpuSos = cpuSos;
	}

}