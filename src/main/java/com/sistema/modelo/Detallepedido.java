package com.sistema.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "detallepedido")
public class Detallepedido  implements Serializable {
	private static final long serialVersionUID=1L;
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Integer iddetallepedido;
	   @Column
	   private Integer cantidad;
	   @Column
	   private Double total;
	  
	   @ManyToOne
	   @JoinColumn(name="id_pedido")
		private Pedido pedido;
	
	   @ManyToOne
	   @JoinColumn(name="id_producto")
		private Producto producto;
	public Detallepedido() {
		
	}
	
	public Detallepedido(Integer iddetallepedido, Integer cantidad, Double total) {
		
		this.iddetallepedido = iddetallepedido;
		this.cantidad = cantidad;
		this.total = total;
	}

	public Integer getIddetallepedido() {
		return iddetallepedido;
	}
	public void setIddetallepedido(Integer iddetallepedido) {
		this.iddetallepedido = iddetallepedido;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	   

}
