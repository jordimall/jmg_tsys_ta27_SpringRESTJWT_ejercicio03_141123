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
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Codigo")
	private Long codigo;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Precio")
	private int precio;

	@OneToMany
	@JoinColumn(name = "Producto")
	private Set<Venta> venta;

	/**
	 * 
	 */
	public Producto() {
	}

	/**
	 * @param nombre
	 * @param precio
	 */
	public Producto(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @return the venta
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Producto")
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
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Set<Venta> venta) {
		this.venta = venta;
	}

}
