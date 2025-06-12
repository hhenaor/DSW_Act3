package com.ejemplo.actividad3.controller;

import com.ejemplo.actividad3.model.Asignatura;
import com.ejemplo.actividad3.model.Usuario;
import com.ejemplo.actividad3.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {
    
    @Autowired
    private AsignaturaService asignaturaService;
    
    @GetMapping
    public String list(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        
        List<Asignatura> asignaturas = asignaturaService.findByUsuarioId(usuario.getId());
        model.addAttribute("asignaturas", asignaturas);
        return "asignaturas/list";
    }
    
    @GetMapping("/new")
    public String newForm(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        model.addAttribute("asignatura", new Asignatura());
        return "asignaturas/form";
    }
    
    @PostMapping
    public String save(@ModelAttribute Asignatura asignatura, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        asignatura.setUsuario(usuario);
        asignaturaService.save(asignatura);
        return "redirect:/asignaturas";
    }
    
    @GetMapping("/{id}")
    public String view(@PathVariable Long id, HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        
        asignaturaService.findById(id).ifPresent(asignatura -> {
            model.addAttribute("asignatura", asignatura);
        });
        return "asignaturas/view";
    }
    
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        
        asignaturaService.findById(id).ifPresent(asignatura -> {
            model.addAttribute("asignatura", asignatura);
        });
        return "asignaturas/form";
    }
    
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        asignaturaService.deleteById(id);
        return "redirect:/asignaturas";
    }
}