package com.example.quickdelivery.repositories;

import com.example.quickdelivery.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
