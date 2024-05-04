package com.sistema.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Citas;



public interface CitasRepository extends JpaRepository<Citas, Integer> {
	List<Citas> findByClienteClienteid(Integer clienteId);
}
