package misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDto {
    private String id;
    private String name;
    private Integer categoryId;
    private String description;
    private String editorial;
    private String imageUrl;
}
