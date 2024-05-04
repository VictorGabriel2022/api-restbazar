package com.sistema.servicios;

import java.util.Collection;

import com.sistema.modelo.Proveedor;

public interface ProveedorService {

	public abstract void insert(Proveedor proveedor);
	public abstract void update(Proveedor proveedor);
	public abstract void delete(Integer id_proveedor);
	public abstract Proveedor findById(Integer id_proveedor);
	public abstract Collection<Proveedor> findAll();
	public abstract Proveedor findByNombre(String nombre);
}
