package com.serejka.blogging.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contacts");
      //  model.addAttribute("activeHead", "Contacts");
        return "contact";
    }
}
