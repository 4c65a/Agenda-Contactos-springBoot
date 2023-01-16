package com.project.contactos.controller;

import com.project.contactos.model.Contactos;
import com.project.contactos.service.ContactosServiceImpl;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contactos")
public class ContactosController {


    @Autowired
    private final ContactosServiceImpl service;

    public ContactosController(ContactosServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/allContactos")
    public ResponseEntity<List<Contactos>> getAllContactos(){
        List<Contactos> contactos = service.getAllContactos();
        if (contactos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new  ResponseEntity<List<Contactos>>(contactos, HttpStatus.OK);
        }
    }


    @PostMapping("/update")
    public ResponseEntity<Void> updateContactos(Contactos contactos){
        service.updateContactos(contactos);
        return new ResponseEntity(contactos, HttpStatus.OK);
    }





    @PutMapping("/add")
    public ResponseEntity<Contactos> addContactos(Contactos contactos){
        if (service.getByNombre(contactos.getNombre())!=null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        } else{
            service.addContactos(contactos);
            return new ResponseEntity<Contactos>(contactos,HttpStatus.CREATED);
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Optional<Contactos>> deleteById(@PathVariable long id){
        Optional<Contactos> contactos = service.seachById(id);
        if (!contactos.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
