package com.example.quickdelivery.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToMany(mappedBy = "cart")
    private List<Commande> commandeList = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }
    public Cart() {
    }

    public Cart(Long id, List<Commande> commandeList) {
        Id = id;
        this.commandeList = commandeList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "Id=" + Id +
                ", commandeList=" + commandeList +
                '}';
    }
}
