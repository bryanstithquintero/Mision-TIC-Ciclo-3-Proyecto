package misiontic.ciclo3.proyecto.subgrupo14.libreria.service;

import java.util.List;
import java.util.Optional;

import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.CategoryDto;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.LibroDto;

public interface ListaService {
    List<CategoryDto> getCategories();

    Optional<CategoryDto> getCategoryById(Integer id);

    List<LibroDto> getLibroByCategoryId(Integer CategoryId);

    List<LibroDto> getAllLibros();

    void saveLibro(LibroDto libro);

    void updateLibro(LibroDto libro);

    void deleteLibro(String code);
}
