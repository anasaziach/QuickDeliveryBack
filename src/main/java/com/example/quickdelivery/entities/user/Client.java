package com.example.quickdelivery.entities.user;


import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Client extends User{
    public Client() {
    }

    public Client(Long id, String firstname, String lastname, String username, String phone, LocalDate birthday) {
        super(id, firstname, lastname, username, phone, birthday);
    }
}
