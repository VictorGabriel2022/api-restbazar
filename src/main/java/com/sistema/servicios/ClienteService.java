package com.sistema.servicios;

import java.util.Collection;

import com.sistema.modelo.Cliente;


public interface ClienteService {
	public abstract void insert(Cliente clientes);
	public abstract void update(Cliente clientes);
	public abstract void delete(Integer clientesid);
	public abstract Cliente findById(Integer clientesid);
	public abstract Collection<Cliente> findAll();
}
