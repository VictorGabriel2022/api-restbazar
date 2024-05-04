package com.sistema.servicios;

import java.util.Collection;

import com.sistema.modelo.Categoria;

public interface CategoriaService {



	public abstract void insert(Categoria categoria);
	public abstract void update(Categoria categoria);
	public abstract void delete(Integer id_categoria);
	public abstract Categoria findById(Integer id_categoria);
	public abstract Collection<Categoria> findAll();
}
