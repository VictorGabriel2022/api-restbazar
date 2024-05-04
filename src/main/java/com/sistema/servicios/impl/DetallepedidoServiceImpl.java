package com.sistema.servicios.impl;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.modelo.Detallepedido;
import com.sistema.repositorios.Detallepedidorepository;
import com.sistema.servicios.DetallepedidoService;

@Service
public class DetallepedidoServiceImpl implements DetallepedidoService{
@Autowired
 private Detallepedidorepository  drepository;
	@Override
	public void insert(Detallepedido dpedidos) {
		drepository.save(dpedidos);
		
	}

	@Override
	public void update(Detallepedido dpedidos) {
		drepository.save(dpedidos);
		
	}

	@Override
	public void delete(Integer dpedidoid) {
		drepository.deleteById(dpedidoid);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Detallepedido findById(Integer dpedidoid) {
		return drepository.findById(dpedidoid).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Detallepedido> findAll() {
		return drepository.findAll();
	}

}
