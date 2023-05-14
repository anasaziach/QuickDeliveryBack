package com.example.quickdelivery.services;


import com.example.quickdelivery.entities.*;
import com.example.quickdelivery.entities.user.User;
import com.example.quickdelivery.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceCreation {
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
}
