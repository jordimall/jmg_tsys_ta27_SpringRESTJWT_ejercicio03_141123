/**
 * 
 */
package com.example.demo.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 */
@Entity
@Table(name="cajeros")
public class Cajero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Codigo")
	private Long codigo;
	
	@Column(name="nom_apels")
	private String nomApels;
	
	@OneToMany
	@JoinColumn(name = "Cajero")
	private Set<Venta> venta;

	/**
	 * 
	 */
	public Cajero() {
	}

	/**
	 * @param nomApels
	 */
	public Cajero(String nomApels) {
		this.nomApels = nomApels;
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @return the nomApels
	 */
	public String getNomApels() {
		return nomApels;
	}

	/**
	 * @return the venta
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Cajero")
	public Set<Venta> getVenta() {
		return venta;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @param nomApels the nomApels to set
	 */
	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Set<Venta> venta) {
		this.venta = venta;
	}
	
	
}
