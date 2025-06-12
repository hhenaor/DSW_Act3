package com.ejemplo.actividad3.controller;

import com.ejemplo.actividad3.model.Usuario;
import com.ejemplo.actividad3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        return "usuario/profile";
    }
    
    @PostMapping("/delete")
    public String deleteAccount(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        usuarioService.deleteById(usuario.getId());
        session.invalidate();
        return "redirect:/login";
    }
}