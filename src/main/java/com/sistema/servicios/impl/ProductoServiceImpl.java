package com.sistema.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.modelo.Producto;
import com.sistema.repositorios.ProductoRepository;
import com.sistema.servicios.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	private ProductoRepository productorepository;
	@Override
	public void insert(Producto productos) {
		productorepository.save(productos);
		
	}

	@Override
	public void update(Producto productos) {
		productorepository.save(productos);
		
	}

	@Override
	public void delete(Integer idproductos) {
		productorepository.deleteById(idproductos);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Integer idproductos) {
		return productorepository.findById(idproductos).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> findAll() {
		// TODO Auto-generated method stub
		return productorepository.findAll();
	}

}
