package com.example.quickdelivery.controllers;


import com.example.quickdelivery.entities.Article;
import com.example.quickdelivery.services.DisplayService;
import com.example.quickdelivery.services.ServiceCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {
    @Autowired
    private ServiceCreation serviceCreation;
    @Autowired
    private DisplayService displayService;
    @GetMapping(path="/api/showItems")
    public List<Article> showItems(){
        return this.displayService.showItems();
    }
}
