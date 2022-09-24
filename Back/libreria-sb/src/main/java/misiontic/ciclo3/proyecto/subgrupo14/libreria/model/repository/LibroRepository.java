package misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findAllByCategoryId(Long categoryId);

    List<Libro> findAllByCategoryIdIn(List<Long> categoryIds);

    List<Libro> findAllByDescriptionLikeOrderByNameAsc(String description);
}
