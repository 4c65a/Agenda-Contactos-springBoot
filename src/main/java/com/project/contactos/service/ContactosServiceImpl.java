package com.project.contactos.service;

import com.project.contactos.model.Contactos;
import com.project.contactos.repository.ContactosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactosServiceImpl implements ContactosService{

    @Autowired
    private ContactosRepository repository;
    @Override
    public List<Contactos> getAllContactos() {
        return repository.findAll();
    }

    @Override
    public List<Contactos> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public void updateContactos(Contactos contactos) {
        repository.save(contactos);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Contactos addContactos(Contactos contactos) {
        return repository.save(contactos);
    }

    @Override
    public Optional<Contactos> seachById(Long id) {
        return Optional.empty();
    }
}
