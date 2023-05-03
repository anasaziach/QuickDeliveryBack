package com.example.quickdelivery.services;


import com.example.quickdelivery.entities.Article;
import com.example.quickdelivery.repositories.ArticleRepository;
import com.example.quickdelivery.repositories.CartRepository;
import com.example.quickdelivery.repositories.CommandeRepository;
import com.example.quickdelivery.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Article> showItems(){
        return this.articleRepository.findAll();
    }
}
