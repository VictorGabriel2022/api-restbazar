package com.sistema.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.modelo.Cliente;
import com.sistema.repositorios.ClienteRepository;

import com.sistema.servicios.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository crepository;
	@Override
	public void insert(Cliente clientes) {
		crepository.save(clientes);
		
		
	}

	@Override
	public void update(Cliente clientes) {
		crepository.save(clientes);
		
	}

	@Override
	public void delete(Integer clientesid) {
		crepository.deleteById(clientesid);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Integer clientesid) {
		return crepository.findById(clientesid).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Cliente> findAll() {
		return crepository.findAll();
	}

}
