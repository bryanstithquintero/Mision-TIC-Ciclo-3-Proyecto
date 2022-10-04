package misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String username;

    private String password;

    private String name;

    private String email;

    private Boolean admin;
}
