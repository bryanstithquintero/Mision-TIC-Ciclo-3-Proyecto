package misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
