package com.ejemplo.actividad3.repository;

import com.ejemplo.actividad3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
    Usuario findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}