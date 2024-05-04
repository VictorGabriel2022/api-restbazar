package com.sistema.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{
	private static final long serialVersionUID=1L;
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer Id;
   @DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
   private LocalDate FechaPedido;
   private Double Total;
   private String estado;
   private String Codigo;
   
   @JsonIgnore
	@OneToMany(mappedBy = "pedido")
	private Collection <Detallepedido> itemsdetallepedido = new ArrayList<>();
  
   @ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
   
   public Pedido() {

}



public Pedido(Integer id, LocalDate fechaPedido, Double total, String estado, String codigo) {
	super();
	Id = id;
	FechaPedido = fechaPedido;
	Total = total;
	this.estado = estado;
	Codigo = codigo;
}



public String getCodigo() {
	return Codigo;
}

public void setCodigo(String codigo) {
	Codigo = codigo;
}

@PostPersist
	public void portPersist() {
	   FechaPedido=LocalDate.now();
	}
public Integer getId() {
	return Id;
}
public void setId(Integer id) {
	Id = id;
}


public LocalDate getFechaPedido() {
	return FechaPedido;
}
public void setFechaPedido(LocalDate fechaPedido) {
	FechaPedido = fechaPedido;
}
public Double getTotal() {
	return Total;
}
public void setTotal(Double total) {
	Total = total;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Collection<Detallepedido> getItemsdetallepedido() {
	return itemsdetallepedido;
}
public void setItemsdetallepedido(Collection<Detallepedido> itemsdetallepedido) {
	this.itemsdetallepedido = itemsdetallepedido;
}



public String getEstado() {
	return estado;
}



public void setEstado(String estado) {
	this.estado = estado;
}
   

}
