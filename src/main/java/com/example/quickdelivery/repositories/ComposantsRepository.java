package com.example.quickdelivery.repositories;

import com.example.quickdelivery.entities.Composant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantsRepository extends JpaRepository<Composant,Long> {
}
