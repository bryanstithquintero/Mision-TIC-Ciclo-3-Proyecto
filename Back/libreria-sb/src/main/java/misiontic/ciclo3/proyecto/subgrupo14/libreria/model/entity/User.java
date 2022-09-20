package misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class User {
    @Id
    @Column(name = "usuario_id")
    private String nombreusuario;

    private String contraseña;

    private String nombre;

    @Column(unique = true)
    private String email;

    private Boolean active;

    private Boolean admin;
}
