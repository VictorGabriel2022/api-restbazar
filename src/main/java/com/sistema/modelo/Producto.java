package com.sistema.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproducto;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String imagen;
	@Column
	private Double precio;
	@Column
	private Integer cantidad;
	@Column
	private Boolean estado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "producto")
	private Collection <Detallepedido> itemsdetallepedido = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "productos")
	private Collection <DetalleHojaCompra> itemsdetallehojacompra = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor", nullable = false)
	private Proveedor proveedor;
	
	public Producto() {
	}
	
	public Producto(Integer idproducto, String nombre, String descripcion, String imagen, Double precio,
			Integer cantidad) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Integer getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Collection<Detallepedido> getItemsdetallepedido() {
		return itemsdetallepedido;
	}

	public void setItemsdetallepedido(Collection<Detallepedido> itemsdetallepedido) {
		this.itemsdetallepedido = itemsdetallepedido;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Collection<DetalleHojaCompra> getItemsdetallehojacompra() {
		return itemsdetallehojacompra;
	}

	public void setItemsdetallehojacompra(Collection<DetalleHojaCompra> itemsdetallehojacompra) {
		this.itemsdetallehojacompra = itemsdetallehojacompra;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	

}
