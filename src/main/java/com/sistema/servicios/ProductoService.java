package com.sistema.servicios;

import java.util.Collection;

import com.sistema.modelo.Producto;




public interface ProductoService {
	public abstract void insert(Producto productos);
	public abstract void update(Producto productos);
	public abstract void delete(Integer idproductos);
	public abstract Producto findById(Integer productoId);
	public abstract Collection<Producto> findAll();
}
