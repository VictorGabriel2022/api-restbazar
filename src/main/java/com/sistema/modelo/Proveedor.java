package com.sistema.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproveedor;
	@Column(unique = true,nullable = false)
	private String nombre;
	@Column(nullable = false)
	private Integer telefono;
	@Column
	private String direccion;
	
	public Proveedor() {
	}

	public Proveedor(Integer id_proveedor, String nombre, Integer telefono, String direccion) {
		this.idproveedor = id_proveedor;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "proveedor")
	private Collection<Producto> itemsProducto=new ArrayList<>();

	public Integer getId_proveedor() {
		return idproveedor;
	}

	public void setId_proveedor(Integer id_proveedor) {
		this.idproveedor = id_proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(Integer idproveedor) {
		this.idproveedor = idproveedor;
	}

	public Collection<Producto> getItemsProducto() {
		return itemsProducto;
	}

	public void setItemsProducto(Collection<Producto> itemsProducto) {
		this.itemsProducto = itemsProducto;
	}
	


}
