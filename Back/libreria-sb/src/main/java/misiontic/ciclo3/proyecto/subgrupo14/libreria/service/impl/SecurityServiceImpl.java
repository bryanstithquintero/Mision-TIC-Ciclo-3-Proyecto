package misiontic.ciclo3.proyecto.subgrupo14.libreria.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.UserRequest;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.UserResponse;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.User;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository.UserRepository;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.service.SecurityService;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;

    @Override
    public UserResponse validateUser(String nombreusuario, String contraseña) {
        var userOp = userRepository.findByUsernameAndPasswordAndActiveIsTrue(nombreusuario, contraseña);
        if (userOp.isEmpty()) {
            throw new RuntimeException("Credenciales inválidas");
        }

        var user = userOp.get();
        return UserResponse.builder()
                .nombreusuario(user.getNombreusuario())
                .nombre(user.getNombre())
                .email(user.getEmail())
                .admin(user.getAdmin())
                .build();
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(u -> UserResponse.builder()
                        .nombreusuario(u.getNombreusuario())
                        .nombre(u.getNombre())
                        .email(u.getEmail())
                        .admin(u.getAdmin())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserByUsername(String nombreusuario) {
        var userOp = userRepository.findById(nombreusuario);
        if (userOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var user = userOp.get();
        return UserResponse.builder()
                .nombreusuario(user.getNombreusuario())
                .nombre(user.getNombre())
                .email(user.getEmail())
                .admin(user.getAdmin())
                .build();
    }

    @Override
    public void createUser(UserRequest user) {
        var userOp = userRepository.findById(user.getNombreusuario());
        if (userOp.isPresent()) {
            throw new RuntimeException("Ya existe un usuario registrado con ese email");
        }

        var userDb = new User();
        userDb.setNombreusuario(user.getNombreusuario());
        userDb.setContraseña(user.getContraseña());
        userDb.setNombre(user.getNombre());
        userDb.setEmail(user.getEmail());
        userDb.setActive(true);
        userDb.setAdmin(user.getAdmin());
        userDb = userRepository.save(userDb);
    }

    @Override
    public void updateUser(UserRequest user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUser(String nombreusuario) {
        // TODO Auto-generated method stub

    }

    @Override
    public void activateUser(String nombreusuario) {
        var userOp = userRepository.findById(nombreusuario);
        if (userOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var user = userOp.get();
        user.setActive(true);
        userRepository.save(user);

    }

    @Override
    public void inactivateUser(String nombreusuario) {
        var userOp = userRepository.findById(nombreusuario);
        if (userOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var user = userOp.get();
        user.setActive(false);
        userRepository.save(user);

    }

}
