package com.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.DetalleHojaCompra;

public interface DhojaRepository extends JpaRepository<DetalleHojaCompra, Integer>{

}
