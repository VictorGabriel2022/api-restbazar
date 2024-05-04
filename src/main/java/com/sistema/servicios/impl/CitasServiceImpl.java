package com.sistema.servicios.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.modelo.Citas;
import com.sistema.repositorios.CitasRepository;
import com.sistema.servicios.CitasService;



@Service
public class CitasServiceImpl implements CitasService {
	@Autowired
	private CitasRepository crepository;
	@Override
	public void insert(Citas citas) {
		crepository.save(citas);
		
		
	}

	@Override
	public void update(Citas citas) {
		crepository.save(citas);
		
	}

	@Override
	public void delete(Integer citaid) {
		crepository.deleteById(citaid);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Citas findById(Integer citaid) {
		return crepository.findById(citaid).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Citas> findAll() {
		return crepository.findAll();
	}

	 @Override
	    @Transactional(readOnly=true)
	    public Collection<Citas> getCitasByClienteId(Integer clienteId) {
	        return crepository.findByClienteClienteid(clienteId);
	    }

}
