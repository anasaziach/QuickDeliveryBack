package com.example.quickdelivery.repositories;

import com.example.quickdelivery.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
