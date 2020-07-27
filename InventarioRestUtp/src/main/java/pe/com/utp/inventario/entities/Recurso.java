package pe.com.utp.inventario.entities;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Recurso generated by hbm2java
 */
@Entity
@Table(name = "recurso")
public class Recurso implements java.io.Serializable {

	private Integer idRecurso;
	private Estado estado;
	private TipoRecurso tipoRecurso;
	private String serie;
	private String marca;
	private String modelo;
	private String capacidad;
	private String observacion;
	private Date fecMod;
	private List<RecursoDispositivo> recursoDispositivos = new ArrayList<>();

	public Recurso() {
	}

	public Recurso(Estado estado, TipoRecurso tipoRecurso, String serie, String marca, String modelo,
			String observacion) {
		this.estado = estado;
		this.tipoRecurso = tipoRecurso;
		this.serie = serie;
		this.marca = marca;
		this.modelo = modelo;
		this.observacion = observacion;
	}

	public Recurso(Estado estado, TipoRecurso tipoRecurso, String serie, String marca, String modelo, String capacidad,
			String observacion, Date fecMod, List<RecursoDispositivo> recursoDispositivos) {
		this.estado = estado;
		this.tipoRecurso = tipoRecurso;
		this.serie = serie;
		this.marca = marca;
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.observacion = observacion;
		this.fecMod = fecMod;
		this.recursoDispositivos = recursoDispositivos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_recurso", unique = true, nullable = false)
	public Integer getIdRecurso() {
		return this.idRecurso;
	}

	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
	}

	@ManyToOne
	@JoinColumn(name = "estado", nullable = false)
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@ManyToOne
	@JoinColumn(name = "id_tiporecurso", nullable = false)
	public TipoRecurso getTipoRecurso() {
		return this.tipoRecurso;
	}

	public void setTipoRecurso(TipoRecurso tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}

	@Column(name = "serie", nullable = false, length = 100)
	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Column(name = "marca", nullable = false, length = 250)
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Column(name = "modelo", nullable = false, length = 250)
	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "capacidad", length = 100)
	public String getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	@Column(name = "observacion", nullable = false, length = 50000)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fec_mod", length = 26)
	public Date getFecMod() {
		return this.fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	@OneToMany(mappedBy = "recurso")
	public List<RecursoDispositivo> getRecursoDispositivos() {
		return this.recursoDispositivos;
	}

	public void setRecursoDispositivos(List<RecursoDispositivo> recursoDispositivos) {
		this.recursoDispositivos = recursoDispositivos;
	}

}
