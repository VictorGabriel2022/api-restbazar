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

@Entity
@Table(name = "detalle_hojacompra")
public class DetalleHojaCompra implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_detallehc;
	@Column
	private Integer cantidad;
	@Column
	private double costo_unitario;
	@Column
	private double importe;
	
	@ManyToOne
	@JoinColumn(name="id_hojacompra")
		private HojaCompra hojaCompra;
	
	@ManyToOne
	@JoinColumn(name="id_producto")
		private Producto productos;
	   
	public DetalleHojaCompra() {
	}

	public DetalleHojaCompra(Integer id_detallehc, Integer cantidad, double costo_unitario, double importe) {
		
		this.id_detallehc = id_detallehc;
		this.cantidad = cantidad;
		this.costo_unitario = costo_unitario;
		this.importe = importe;
	}

	public Integer getId_detallehc() {
		return id_detallehc;
	}

	public void setId_detallehc(Integer id_detallehc) {
		this.id_detallehc = id_detallehc;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getCosto_unitario() {
		return costo_unitario;
	}

	public void setCosto_unitario(double costo_unitario) {
		this.costo_unitario = costo_unitario;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public HojaCompra getHojaCompra() {
		return hojaCompra;
	}

	public void setHojaCompra(HojaCompra hojaCompra) {
		this.hojaCompra = hojaCompra;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}

	
	
}
