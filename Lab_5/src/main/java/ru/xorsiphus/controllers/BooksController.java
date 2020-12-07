package ru.xorsiphus.controllers;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.xorsiphus.dao.services.BookServiceImpl;
import ru.xorsiphus.entity.Book;

@Controller
@RequestMapping("/books")
public class BooksController
{
    private final BookServiceImpl bookService;

    public BooksController(@Qualifier("bookService") BookServiceImpl bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping
    public String viewAll(Model model)
    {
        model.addAttribute("books", bookService.findAll());
        return "books/all";
    }

    @GetMapping("/{id}")
    public String viewOne(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("book", bookService.findById(id).orElse(new Book()));
        return "books/single";
    }

    @PostMapping
    public String create(@ModelAttribute("book") Book book)
    {
        var temp = book;
//        bookService.insert(book);
        return "redirect:/books";
    }

    @GetMapping("/new")
    public String addBook(@ModelAttribute("book") Book book)
    {
        return "books/new";
    }

}
