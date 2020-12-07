package ru.xorsiphus.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xorsiphus.dao.repositories.BooksJPA;

@Controller
@RequestMapping("/")
public class MainPageController
{
    private final BooksJPA booksJPA;

    public MainPageController(@Qualifier("booksJPA") BooksJPA booksJPA) {
        this.booksJPA = booksJPA;
    }

    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("count", booksJPA.count());
        return "index";
    }
}

