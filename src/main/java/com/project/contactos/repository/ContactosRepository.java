package com.project.contactos.repository;

import com.project.contactos.model.Contactos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactosRepository extends JpaRepository<Contactos, Long> {
    List<Contactos> findByNombre(String nombre);
    
}