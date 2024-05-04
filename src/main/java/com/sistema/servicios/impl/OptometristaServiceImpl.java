package com.sistema.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.modelo.Optometrista;
import com.sistema.repositorios.OptometristaRepository;
import com.sistema.servicios.OptometristaService;



@Service
public class OptometristaServiceImpl implements OptometristaService {

	@Autowired
	private OptometristaRepository crepository;
	@Override
	public void insert(Optometrista optometrista) {
		crepository.save(optometrista);
		
		
	}

	@Override
	public void update(Optometrista optometrista) {
		crepository.save(optometrista);
		
	}

	@Override
	public void delete(Integer optometristaid) {
		crepository.deleteById(optometristaid);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optometrista findById(Integer optometristaid) {
		return crepository.findById(optometristaid).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Optometrista> findAll() {
		return crepository.findAll();
	}

}
