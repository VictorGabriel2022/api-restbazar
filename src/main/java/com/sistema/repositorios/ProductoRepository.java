package com.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
