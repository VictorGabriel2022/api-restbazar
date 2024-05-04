package com.sistema.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hoja_compra")
public class HojaCompra implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_hojacompra;
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate Fecha_compra;
	@Column
	private String direccion_entrega;
	@Column
	private String nrofactura;
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	@Column
	private LocalDate fecha;
	@Column
	private double total;
	@Column
	private Boolean estado;
	@JsonIgnore
	@OneToMany(mappedBy = "hojaCompra")
	private Collection<DetalleHojaCompra> itemsdetallehojacompra = new ArrayList<>();
	
	public HojaCompra() {
	}
	





	public HojaCompra(Integer id_hojacompra, LocalDate fecha_compra, String direccion_entrega, String nrofactura,
			LocalDate fecha, double total, Boolean estado) {
		super();
		this.id_hojacompra = id_hojacompra;
		Fecha_compra = fecha_compra;
		this.direccion_entrega = direccion_entrega;
		this.nrofactura = nrofactura;
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
	}






	public Integer getId_hojacompra() {
		return id_hojacompra;
	}

	public void setId_hojacompra(Integer id_hojacompra) {
		this.id_hojacompra = id_hojacompra;
	}

	public LocalDate getFecha_compra() {
		return Fecha_compra;
	}

	public void setFecha_compra(LocalDate fecha_compra) {
		Fecha_compra = fecha_compra;
	}

	public String getDireccion_entrega() {
		return direccion_entrega;
	}

	public void setDireccion_entrega(String direccion_entrega) {
		this.direccion_entrega = direccion_entrega;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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






	public String getNrofactura() {
		return nrofactura;
	}






	public void setNrofactura(String nrofactura) {
		this.nrofactura = nrofactura;
	}






	public LocalDate getFecha() {
		return fecha;
	}






	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	
	
}
