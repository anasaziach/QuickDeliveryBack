package com.example.quickdelivery.entities.user;


import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Fournisseur extends User{
    public Fournisseur() {
    }

    public Fournisseur(String username) {
        super(username);
    }
}
