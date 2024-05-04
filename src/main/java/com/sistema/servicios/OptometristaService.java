package com.sistema.servicios;

import java.util.Collection;

import com.sistema.modelo.Optometrista;



public interface OptometristaService {

	public abstract void insert(Optometrista optometrista);
	public abstract void update(Optometrista optometrista);
	public abstract void delete(Integer optometristaid);
	public abstract Optometrista findById(Integer optometristaid);
	public abstract Collection<Optometrista> findAll();
}
