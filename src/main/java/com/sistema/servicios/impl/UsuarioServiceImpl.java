package com.sistema.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.modelo.Usuario;
import com.sistema.modelo.UsuarioRol;
import com.sistema.repositorios.RolRepository;
import com.sistema.repositorios.UsuarioRepository;
import com.sistema.servicios.UsuarioService;

import java.util.Collection;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

	@Override
	public Collection<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Collection<Usuario> findAllConRoles() {
		 Collection<Usuario> usuarios = usuarioRepository.findAll();
	        usuarios.forEach(usuario -> usuario.setUsuarioRoles(usuario.getUsuarioRoles()));
	        return usuarios;
	}

}