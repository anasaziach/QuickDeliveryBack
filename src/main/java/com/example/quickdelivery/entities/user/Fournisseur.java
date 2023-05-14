package com.example.quickdelivery.entities.user;


import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Fournisseur extends User{
    public Fournisseur() {
    }

    public Fournisseur(Long id, String firstname, String lastname, String username, String phone, LocalDate birthday) {
        super(id, firstname, lastname, username, phone, birthday);
    }
}
