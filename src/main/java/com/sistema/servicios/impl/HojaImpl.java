package com.sistema.servicios.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.modelo.HojaCompra;

import com.sistema.repositorios.HojaRepository;

import com.sistema.servicios.HojaService;
@Service
public class HojaImpl implements HojaService {
	@Autowired
	private HojaRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Collection<HojaCompra> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public void insert(HojaCompra hoja) {
		repository.save(hoja);
		
	}
	@Override
	public HojaCompra findById(Integer idHojacompra) {
		return repository.findById(idHojacompra).orElse(null);
	}
	@Override
	public void update(HojaCompra hoja) {
		repository.save(hoja);
		
	}
	@Override
	public void delete(Integer idHojacompra) {
		// TODO Auto-generated method stub
		
	}
	
	



}
