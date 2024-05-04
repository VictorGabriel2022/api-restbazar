package com.sistema.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.modelo.Categoria;
import com.sistema.repositorios.CategoriaRepository;
import com.sistema.servicios.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	@Transactional
	public void insert(Categoria categoria) {
		// TODO Auto-generated method stub
		repository.save(categoria);
	}

	@Override
	@Transactional
	public void update(Categoria categoria) {
		// TODO Auto-generated method stub
		repository.save(categoria);
	}

	@Override
	@Transactional
	public void delete(Integer id_categoria) {
		// TODO Auto-generated method stub
		repository.deleteById(id_categoria);
	}

	@Override
	@Transactional(readOnly=true)
	public Categoria findById(Integer id_categoria) {
		// TODO Auto-generated method stub
		return repository.findById(id_categoria).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Categoria> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
