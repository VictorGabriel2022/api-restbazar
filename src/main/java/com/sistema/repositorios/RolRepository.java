package com.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Rol;

public interface RolRepository extends JpaRepository<Rol,Long> {
}
