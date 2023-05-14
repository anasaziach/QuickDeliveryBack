package com.example.quickdelivery.entities.user;


import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Client extends User{
    public Client() {
    }

    public Client(String username) {
        super(username);
    }
}
