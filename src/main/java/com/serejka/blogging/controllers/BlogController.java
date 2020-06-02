package com.serejka.blogging.controllers;

import com.serejka.blogging.models.Article;
import com.serejka.blogging.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @Autowired
    private ArticleRepository articleRepository;


    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("title", "Blog");
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        //model.addAttribute("activeHead", "Blog");
        return "blog";
    }
}
