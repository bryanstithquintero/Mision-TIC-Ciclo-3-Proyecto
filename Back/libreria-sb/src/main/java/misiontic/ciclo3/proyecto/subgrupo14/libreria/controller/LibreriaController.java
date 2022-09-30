package misiontic.ciclo3.proyecto.subgrupo14.libreria.controller;

import javax.annotation.Generated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lombok.AllArgsConstructor;
import lombok.var;
import lombok.extern.slf4j.Slf4j;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.LibroDto;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.service.ListaService;

@AllArgsConstructor
@Controller
@Slf4j
public class LibreriaController {

    private ListaService listaService;

    @GetMapping(value = { "/", "/index", "/index.html" })
    public String goToIndex(Model model) {
        return "index";
    }

    @GetMapping("/DatosUsuario")
    public String goToDatosUsuario(Model model) {
        return "DatosUsuario";
    }

    @GetMapping("/catalogo")
    public String goToCatalogo(Model model) {
        var categories = this.listaService.getCategories();

        model.addAttribute("title", "Bienvenido");
        model.addAttribute("categories", categories);
        return "catalogo";
    }

    @GetMapping("/catalogo/{id}")
    public String loadListaById(@PathVariable("id") Integer id, Model model) {
        log.info("Cargando informacion de categoria {}", id);
        var categories = listaService.getCategories();
        model.addAttribute("categories", categories);

        var categoryOp = this.listaService.getCategoryById(id);
        if (categoryOp.isEmpty()) {
            model.addAttribute("error", "La categoria no existe");
        } else {
            var category = categoryOp.get();

            model.addAttribute("title", category.getName());
            model.addAttribute("id", category.getId());

            var categoryLibros = this.listaService.getLibroByCategoryId(id);

            model.addAttribute("libros", categoryLibros);
        }
        return "catalogo";
    }

    @GetMapping("/principal")
    public String goToprincipal(Model model) {

        return "principal";
    }

    @GetMapping("/RegistroLibros")
    public String goToRegistroLibros(Model model) {
        var libro = this.listaService.getAllLibros();
        model.addAttribute("libro", libro);
        return "RegistroLibros";
    }

    @GetMapping("/RegistroLibros/nuevo")
    public String goToFormulario(Model model) {
        LibroDto libro = new LibroDto();
        model.addAttribute("libro", libro);
        return "crearLibro";
    }

    @PostMapping("/RegistroLibros/libro")
    public String guardarLibro(@ModelAttribute LibroDto libro, Model model) {

        log.info(libro.toString());
        listaService.saveLibro(libro);
        return "redirect:/RegistroLibros";
    }

}
