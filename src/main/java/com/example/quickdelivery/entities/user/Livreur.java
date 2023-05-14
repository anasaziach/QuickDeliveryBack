package com.example.quickdelivery.entities.user;


import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Livreur extends User{
    public Livreur() {
    }

    public Livreur(String username) {
        super(username);
    }
}
