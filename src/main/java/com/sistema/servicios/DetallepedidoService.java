package com.sistema.servicios;

import java.util.Collection;

import com.sistema.modelo.Detallepedido;


public interface DetallepedidoService {
	public abstract void insert(Detallepedido dpedidos);
	public abstract void update(Detallepedido dpedidos);
	public abstract void delete(Integer dpedidoid);
	public abstract Detallepedido findById(Integer dpedidoid);
	public abstract Collection<Detallepedido> findAll();
}
