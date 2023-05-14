package com.example.quickdelivery.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToMany
    @JoinTable(name = "Article_Commande",
        joinColumns = @JoinColumn(name = "commande_id"),
        inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private List<Article> articleList;
    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;
    private Long Total = 0L;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Commande() {
    }

    public Commande(List<Article> articleList) {
        this.articleList = articleList;
        articleList.stream()
                .forEach(x->this.Total+=x.getTotal());
    }
    public Article addArticle(Article article){
        this.articleList.add(article);
        this.Total+=article.getTotal();
        return article;
    }
}
