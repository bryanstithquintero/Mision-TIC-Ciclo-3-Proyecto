package misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameAndPasswordAndActiveIsTrue(String username, String password);

    Optional<User> findByEmail(String email);
}
