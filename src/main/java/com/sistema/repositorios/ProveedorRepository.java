package com.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

	Proveedor findByNombre(String nombre);

}
