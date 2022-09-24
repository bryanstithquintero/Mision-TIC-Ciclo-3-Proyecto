package misiontic.ciclo3.proyecto.subgrupo14.libreria.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.CategoryDto;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.LibroDto;
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

}
