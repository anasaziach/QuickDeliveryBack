package com.example.quickdelivery.repositories;

import com.example.quickdelivery.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
