package com.ejemplo.actividad3.repository;

import com.ejemplo.actividad3.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    List<Asignatura> findByUsuarioId(Long usuarioId);
}