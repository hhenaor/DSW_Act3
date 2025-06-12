package com.ejemplo.actividad3.controller;

import com.ejemplo.actividad3.model.Usuario;
import com.ejemplo.actividad3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String home() {
        return "login";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, 
                       @RequestParam String password, 
                       HttpSession session, 
                       Model model) {
        Usuario usuario = usuarioService.authenticate(username, password);
        if (usuario != null) {
            session.setAttribute("usuario", usuario);
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";

    }
    
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
    @PostMapping("/register")
    public String register(@ModelAttribute Usuario usuario, Model model) {
        if (usuarioService.existsByUsername(usuario.getUsername())) {
            model.addAttribute("error", "El usuario ya existe");
            return "register";
        }
        if (usuarioService.existsByEmail(usuario.getEmail())) {
            model.addAttribute("error", "El email ya está registrado");
            return "register";
        }

        usuarioService.save(usuario);
        return "redirect:/login";

    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        return "dashboard";
    }

}