package misiontic.ciclo3.proyecto.subgrupo14.libreria.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.CategoryDto;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.LibroDto;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.Libro;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository.CategoryRepository;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository.LibroRepository;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.service.ListaService;

@AllArgsConstructor
@Service
public class ListaServiceImpl implements ListaService {

    private final CategoryRepository categoryRepository;
    private final LibroRepository libroRepository;

    @Override
    public List<CategoryDto> getCategories() {
        var categories = categoryRepository.findAll(Sort.by("name"));
        return categories.stream()
                .map(cat -> new CategoryDto(cat.getName(), cat.getId().intValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDto> getCategoryById(Integer id) {
        var category = categoryRepository.findById(id.longValue());
        if (category.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new CategoryDto(category.get().getName(), category.get().getId().intValue()));
    }

    @Override
    public List<LibroDto> getLibroByCategoryId(Integer CategoryId) {
        var libros = libroRepository.findAllByCategoryId(CategoryId.longValue());

        var categoryLibros = libros.stream()
                .map(lib -> LibroDto.builder()
                        .id(lib.getCode())
                        .name(lib.getName())
                        .description(lib.getDescription())
                        .editorial(lib.getEditorial())
                        .imageUrl(lib.getImageUrl())
                        .build())
                .collect(Collectors.toList());

        return categoryLibros;
    }

    @Override
    public List<LibroDto> getAllLibros() {
        var libros = libroRepository.findAll();

        var libro = libros.stream()
                .map(lib -> LibroDto.builder()
                        .id(lib.getCode())
                        .name(lib.getName())
                        .description(lib.getDescription())
                        .editorial(lib.getEditorial())
                        .imageUrl(lib.getImageUrl())
                        .build())
                .collect(Collectors.toList());
        return libro;
    }

    @Override
    public void saveLibro(LibroDto libro) {
        var entity = new Libro();
        entity.setCode(libro.getId());
        entity.setName(libro.getName());
        entity.setDescription(libro.getDescription());
        entity.setEditorial(libro.getEditorial());
        entity.setImageUrl(libro.getImageUrl());

        libroRepository.save(entity);
    }

    @Override
    public LibroDto updateLibro(LibroDto libro) {
        var libroOp = libroRepository.findById(libro.getId());
        if (libroOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }
        var libroDb = libroOp.get();
        libroDb.setCode(libro.getId());
        libroDb.setName(libro.getName());
        libroDb.setDescription(libro.getDescription());
        libroDb.setEditorial(libro.getEditorial());
        libroDb.setImageUrl(libro.getImageUrl());
        libroDb = libroRepository.save(libroDb);

        return libro;

    }

    @Override
    public void deleteLibro(String code) {
        var libroOp = libroRepository.findById(code);
        if (libroOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }
        libroRepository.delete(libroOp.get());

    }

    @Override
    public Optional<LibroDto> getLibrobyId(String id) {
        var libros = libroRepository.findById(id);
        if (libros.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new LibroDto(libros.get().getCode(), libros.get().getName(), null,
                libros.get().getDescription(), libros.get().getEditorial(), libros.get().getImageUrl()));
    }

}
