package com.example.quickdelivery.services;


import com.example.quickdelivery.entities.*;
import com.example.quickdelivery.entities.user.User;
import com.example.quickdelivery.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceCreation implements CommandLineRunner {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComposantsRepository composantsRepository;
    @Autowired
    private ImageRepository imageRepository;
    public Article createArticle(String name, String Description, List<Composant> composants,List<Image> images , Categories category){
        Article article = new Article(name , Description , composants , category);
        composants.stream().forEach(x->x.setArticle(article));
        images.stream().forEach(x->x.setArticle(article));
        this.articleRepository.save(article);
        this.composantsRepository.saveAll(composants);
        this.imageRepository.saveAll(images);
        return article;
    }
    public Commande createCommande(Long idUser, List<Article> articles){//we should make sure that we have min one item on board
        Cart cart;
        User user = this.userRepository.findById(idUser)
                          .orElseThrow(()->new RuntimeException("User not found!"));
        if(user.getCart()!=null) cart = user.getCart();
        else {
            cart = new Cart();
            user.setCart(cart);
            this.cartRepository.save(cart);
            this.userRepository.save(user);
        }
        Commande commande = new Commande(articles);
        commande.setCart(cart);
        return this.commandeRepository.save(commande);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Composant> composants = new ArrayList<>();
        List<Image> images = new ArrayList<>();
        composants.add(new Composant("tomate",12L));
        composants.add(new Composant("ognion",2L));
        composants.add(new Composant("pain",4L));
        images.add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVb7M3-kkwI9AScXHaC0hrJJJ4N3uK2edSZxOQLFce&s"));
        createArticle("burger","chickenBurger",composants,images,Categories.fast_food);
    }
}
