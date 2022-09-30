package misiontic.ciclo3.proyecto.subgrupo14.libreria.service;

import java.util.List;
import java.util.Optional;

import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.CategoryDto;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.LibroDto;

public interface ListaService {
    List<CategoryDto> getCategories();

    Optional<CategoryDto> getCategoryById(Integer id);

    List<LibroDto> getLibroByCategoryId(Integer CategoryId);

    Optional<LibroDto> getLibrobyId(String id);

    List<LibroDto> getAllLibros();

    void saveLibro(LibroDto libro);

    LibroDto updateLibro(LibroDto libro);

    void deleteLibro(String code);
}
