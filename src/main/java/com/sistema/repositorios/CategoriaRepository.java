package com.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
