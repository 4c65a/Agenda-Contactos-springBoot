package com.project.contactos.service;

import com.project.contactos.model.Contactos;

import java.util.List;
import java.util.Optional;

public interface ContactosService {

    public List<Contactos> getAllContactos();
    public List<Contactos> getByNombre(String nombre);
    public void updateContactos(Contactos contactos);
    public void deleteById(long id);
    public  Contactos addContactos(Contactos contactos);

    public Optional<Contactos> seachById(Long id);
}
