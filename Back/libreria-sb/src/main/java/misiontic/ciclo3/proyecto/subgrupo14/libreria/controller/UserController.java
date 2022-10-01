package misiontic.ciclo3.proyecto.subgrupo14.libreria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.UserRequest;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.service.SecurityService;

@Controller
@RequestMapping("/registro")
public class UserController {
    private SecurityService securityService;

    @ModelAttribute("usuario")
    public UserRequest retornarNuevoUserDTO() {
        return new UserRequest();
    }

    @GetMapping
    public String mostrarFormularioRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaUsuario(@ModelAttribute("usuario") UserRequest registro) {
        this.securityService.createUser(registro);
        return "redirect:/Login";
    }
}
