package misiontic.ciclo3.proyecto.subgrupo14.libreria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Controller
@Slf4j
public class LibreriaController {

    @GetMapping(value = { "/", "/index", "/index.html" })
    public String goToIndex(Model model) {
        return "index";
    }

    @GetMapping("/DatosUsuario")
    public String goToDatosUsuario(Model model) {
        return "DatosUsuario";
    }

    @GetMapping("/listaLibros")
    public String goToClistaLibros(Model model) {
        return "listaLibros";
    }

    @GetMapping("/principal")
    public String goToprincipal(Model model) {
        return "principal";
    }

    @GetMapping("/RegistroLibros")
    public String goToRegistroLibros(Model model) {
        return "RegistroLibros";
    }

}
