package misiontic.ciclo3.proyecto.subgrupo14.libreria.service;

import java.util.List;

import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.UserRequest;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.UserResponse;

public interface SecurityService {

    UserResponse validateUser(String nombreusuario, String contraseña);

    List<UserResponse> getAllUsers();

    UserResponse getUserByUsername(String nombreusuario);

    void createUser(UserRequest user);

    void updateUser(UserRequest user);

    void deleteUser(String nombreusuario);

    void activateUser(String nombreusuario);

    void inactivateUser(String nombreusuario);
}
