package misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @Id
    private String code;

    private String name;
    private String description;
    private String editorial;
    private String imageUrl;

    @ManyToOne
    private Category category;
}
