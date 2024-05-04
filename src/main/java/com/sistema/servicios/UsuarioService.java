package com.sistema.servicios;

import java.util.Collection;
import java.util.Set;

import com.sistema.modelo.Usuario;
import com.sistema.modelo.UsuarioRol;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
    public abstract Collection<Usuario>findAll();
    Collection<Usuario> findAllConRoles();
}
