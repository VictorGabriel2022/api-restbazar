package com.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}
