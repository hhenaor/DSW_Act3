package com.ejemplo.actividad3.service;

import com.ejemplo.actividad3.model.Asignatura;
import com.ejemplo.actividad3.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {
    
    @Autowired
    private AsignaturaRepository asignaturaRepository;
    
    public List<Asignatura> findByUsuarioId(Long usuarioId) {
        return asignaturaRepository.findByUsuarioId(usuarioId);
    }
    
    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }
    
    public Optional<Asignatura> findById(Long id) {
        return asignaturaRepository.findById(id);
    }
    
    public void deleteById(Long id) {
        asignaturaRepository.deleteById(id);
    }
    
    public List<Asignatura> findAll() {
        return asignaturaRepository.findAll();
    }
}