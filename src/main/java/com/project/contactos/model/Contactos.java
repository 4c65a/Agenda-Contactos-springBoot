package com.project.contactos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "contactos")
public class Contactos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String apodo;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String numero;
    @Email
    @Column(nullable = false)
    private String email;

    @URL
    @Column(nullable = false)
    private String linkedin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}