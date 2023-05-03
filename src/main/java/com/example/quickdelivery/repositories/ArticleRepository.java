package com.example.quickdelivery.repositories;

import com.example.quickdelivery.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
