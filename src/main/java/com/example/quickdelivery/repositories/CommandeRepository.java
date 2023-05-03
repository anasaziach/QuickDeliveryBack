package com.example.quickdelivery.repositories;

import com.example.quickdelivery.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
