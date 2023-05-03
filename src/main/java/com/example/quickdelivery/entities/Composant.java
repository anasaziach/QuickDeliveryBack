package com.example.quickdelivery.entities;


import jakarta.persistence.*;

@Entity
public class Composant {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private Long price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    public Composant() {
    }

    public Composant(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public Composant(String name, Long price, Article article) {
        this.name = name;
        this.price = price;
        this.article = article;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Composant{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", article=" + article +
                '}';
    }
}
