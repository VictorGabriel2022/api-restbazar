package com.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
