package com.example.quickdelivery.entities;


import jakarta.persistence.*;
import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "article",fetch = FetchType.EAGER)
    private List<Composant> composantList = new ArrayList<>();
    @OneToMany(mappedBy = "article",fetch = FetchType.EAGER)
    private List<Image> images = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Categories category;

    private Long Total=0L;


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

    public List<Composant> getComposantList() {
        return composantList;
    }

    public void setComposantList(List<Composant> composantList) {
        this.composantList = composantList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTotal() {
        return Total;
    }

    public void setTotal(Long total) {
        Total = total;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Article() {

    }

    public Article(String name,Long total) {
        this.name = name;
        this.setTotal(total);
    }

    public Article(String name, String description, List<Composant> composantList , Categories category) {
        this.name = name;
        this.description = description;
        this.composantList = composantList;
        composantList.stream()
                .forEach(x->this.Total+=x.getPrice());
        this.category=category;
    }

    public Article(String name, String description, List<Composant> composantList, List<Image> images) {
        this.name = name;
        this.description = description;
        this.composantList = composantList;
        this.images = images;
        composantList.stream()
                .forEach(x->this.Total+=x.getPrice());
    }

    @Override
    public String toString() {
        return "Article{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", composantList=" + composantList +
                ", images=" + images +
                ", category=" + category +
                ", Total=" + Total +
                '}';
    }
}
