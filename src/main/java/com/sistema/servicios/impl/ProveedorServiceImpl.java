package com.sistema.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.modelo.Proveedor;
import com.sistema.repositorios.ProveedorRepository;
import com.sistema.servicios.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository reporsitory;
	
	@Override
	@Transactional
	public void insert(Proveedor proveedor) {
		// TODO Auto-generated method stub
		reporsitory.save(proveedor);
	}

	@Override
	@Transactional
	public void update(Proveedor proveedor) {
		// TODO Auto-generated method stub
		reporsitory.save(proveedor);
	}

	@Override
	@Transactional
	public void delete(Integer id_proveedor) {
		// TODO Auto-generated method stub
		reporsitory.deleteById(id_proveedor);
	}

	@Override
	@Transactional(readOnly=true)
	public Proveedor findById(Integer id_proveedor) {
		// TODO Auto-generated method stub
		return reporsitory.findById(id_proveedor).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Proveedor> findAll() {
		// TODO Auto-generated method stub
		return reporsitory.findAll();
	}

	@Override
	public Proveedor findByNombre(String nombre) {
	    return reporsitory.findByNombre(nombre);
	}

}
