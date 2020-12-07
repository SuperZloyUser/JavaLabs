package ru.xorsiphus.controllers;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.xorsiphus.dao.services.BookServiceImpl;
import ru.xorsiphus.entity.Book;
import ru.xorsiphus.parser.DateParser;

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
        return "books/all";
    }

    @GetMapping("/{id}")
    public String viewOne(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("book", bookService.findById(id).orElse(new Book()));
        return "books/single";
    }

    @PostMapping
    public String create(@RequestParam(name="name") String name,
                         @RequestParam(name="author") String author,
                         @RequestParam(name="print_edition", required=false, defaultValue="Printer") String printEdition,
                         @RequestParam(name="size_in_pages") int sizeInPages,
                         @RequestParam(name="published_on", required=false, defaultValue="2-1-1970") String publishedOn)
    {
        var temp = new Book(name, author, printEdition, sizeInPages, DateParser.parseDate(publishedOn));
        bookService.insert(temp);
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
    public String update(@ModelAttribute("book") Book book, @PathVariable("id") int id)
    {
        bookService.updateById(id, book);
        return "redirect:/books";
    }

}
