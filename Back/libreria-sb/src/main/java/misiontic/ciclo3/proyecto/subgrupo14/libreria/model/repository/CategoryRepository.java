package misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String string);
}
