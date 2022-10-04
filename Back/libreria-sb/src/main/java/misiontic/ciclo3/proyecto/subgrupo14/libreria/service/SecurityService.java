package misiontic.ciclo3.proyecto.subgrupo14.libreria.service;

import java.util.List;

import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.UserRequest;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.UserResponse;

public interface SecurityService {

    UserResponse validateUser(String username, String password);

    List<UserResponse> getAllUsers();

    UserResponse getUserByUsername(String username);

    void createUser(UserRequest user);

    void updateUser(UserRequest user);

    void deleteUser(String username);

    void activateUser(String username);

    void inactivateUser(String username);
}
