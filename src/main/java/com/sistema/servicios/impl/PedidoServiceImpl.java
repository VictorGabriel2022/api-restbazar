package com.sistema.servicios.impl;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.modelo.Pedido;
import com.sistema.repositorios.PedidoRepository;
import com.sistema.servicios.PedidoService;
@Service
public class PedidoServiceImpl implements PedidoService{
     @Autowired
     private PedidoRepository pedidorepository;
	@Override
	public void insert(Pedido pedidos) {
		pedidorepository.save(pedidos);
		
	}

	@Override
	public void update(Pedido pedidos) {
		pedidorepository.save(pedidos);
		
	}

	@Override
	public void delete(Integer pedidoid) {
		pedidorepository.deleteById(pedidoid);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Pedido findById(Integer pedidoid) {
		return pedidorepository.findById(pedidoid).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Pedido> findAll() {
		return pedidorepository.findAll();
	}

	@Override
	public Pedido save(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidorepository.save(pedido);
	}

	@Override
	public Collection<Object[]> ultimopedido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Object[]> findAll_withPedidos() {
		// TODO Auto-generated method stub
		return  pedidorepository.findAll_withPedidos();
	}
	
	@Override
	public Collection<Pedido> getPedidoByClienteId(Integer clienteId) {
		return pedidorepository.findByClienteClienteid(clienteId);
	}
	

}
