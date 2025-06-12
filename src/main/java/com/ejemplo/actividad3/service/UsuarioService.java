package com.ejemplo.actividad3.service;

import com.ejemplo.actividad3.model.Usuario;
import com.ejemplo.actividad3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
    
    public boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }
    
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
    
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
    
    public Usuario authenticate(String username, String password) {
        Usuario usuario = findByUsername(username);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null;
    }
}