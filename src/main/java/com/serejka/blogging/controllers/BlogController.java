package com.serejka.blogging.controllers;

import com.serejka.blogging.models.Article;
import com.serejka.blogging.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        model.addAttribute("title", "Blog");
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String formAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String fullText, Model model) {
        model.addAttribute("title", "Blog");
        Article article = new Article(title, anons, fullText);
        articleRepository.save(article);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String articleDetail(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("title", "Blog");
        if (!articleRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Article> article =  articleRepository.findById(id);
        List<Article> articleList = new ArrayList<>();
        article.ifPresent(articleList::add);
        model.addAttribute("title", articleList.get(0).getTitle());
        model.addAttribute("article", articleList);
        return "article-details";
    }

}
