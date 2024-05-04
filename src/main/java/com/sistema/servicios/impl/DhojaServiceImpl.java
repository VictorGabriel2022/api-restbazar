package com.sistema.servicios.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.modelo.DetalleHojaCompra;

import com.sistema.repositorios.DhojaRepository;
import com.sistema.servicios.DhojaService;
@Service
public class DhojaServiceImpl implements DhojaService{
	@Autowired
	private DhojaRepository repository;
	@Override
	public Collection<DetalleHojaCompra> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void insert(DetalleHojaCompra dhoja) {
		repository.save(dhoja);
		
	}

	@Override
	public void insertAll(List<DetalleHojaCompra> dhojaList) {
	   repository.saveAll(dhojaList);
	}


}
