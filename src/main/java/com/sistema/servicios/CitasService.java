package com.sistema.servicios;

import java.util.Collection;

import com.sistema.modelo.Citas;



public interface CitasService {

	public abstract void insert(Citas citas);
	public abstract void update(Citas citas);
	public abstract void delete(Integer citaid);
	public abstract Citas findById(Integer citaid);
	public abstract Collection<Citas> findAll();
	 Collection<Citas> getCitasByClienteId(Integer clienteId);
}
