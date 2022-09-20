package misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private String nombreusuario;

    private String nombre;

    private String email;

    private Boolean admin;
}
