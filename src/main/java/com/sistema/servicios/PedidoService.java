package com.sistema.servicios;

import java.util.Collection;

import com.sistema.modelo.Pedido;


public interface PedidoService {
	public abstract void insert(Pedido pedidos);
	public abstract void update(Pedido pedidos);
	public abstract void delete(Integer pedidoid);
	public abstract Pedido findById(Integer pedidoid);
	public abstract Collection<Pedido> findAll();
	public abstract Pedido save(Pedido pedido);
	public abstract Collection<Object[]> ultimopedido();
	public abstract Collection<Object[]> findAll_withPedidos();
	
	Collection<Pedido> getPedidoByClienteId(Integer clienteId);

}
