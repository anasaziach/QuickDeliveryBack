package com.example.quickdelivery.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDateTime time = LocalDateTime.now();
    @ManyToOne
    private Article article;
    private String Uri;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

//    public Article getArticle() {
//        return article;
//    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public Image() {
    }

    public Image(Article article , String Uri) {
        this.article = article;
        this.Uri= Uri;
    }


}
