package ru.xorsiphus.controllers;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.xorsiphus.dao.services.BookServiceImpl;
import ru.xorsiphus.entity.Book;
import ru.xorsiphus.parser.forms.FilterAuthor;

import javax.validation.Valid;

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
        model.addAttribute("count", bookService.count());
        model.addAttribute("filterAuthor", new FilterAuthor());
        return "books/all";
    }

    @GetMapping("/{id}")
    public String viewOne(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("book", bookService.findById(id).orElse(new Book()));
        return "books/single";
    }

    @PostMapping
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "books/new";

        bookService.insert(book);
        return "redirect:/books";
    }

    @GetMapping("/new")
    public String addBook(@ModelAttribute("book") Book book)
    {
        return "books/new";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("book", bookService.findById(id).orElse(new Book()));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult, @PathVariable("id") int id)
    {
        if (bindingResult.hasErrors())
            return "books/edit";
        bookService.updateById(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id)
    {
        bookService.removeById(id);
        return "redirect:/books";
    }

    @PostMapping("/filtered")
    public String viewByFilter(@ModelAttribute("filterAuthor") @Valid FilterAuthor filterAuthor, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("books", bookService.findAll());
            model.addAttribute("count", bookService.count());
            return "books/all";
        }

        model.addAttribute("books", bookService.findByAuthor(filterAuthor.getFilter()));
        return "books/filtered";
    }

}
