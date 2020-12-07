package ru.xorsiphus.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xorsiphus.dao.services.BooksServiceImpl;
import ru.xorsiphus.parser.forms.Id;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/view")
public class ViewBooksController
{
    private final BooksServiceImpl booksService;

    public ViewBooksController(@Qualifier("booksServiceImpl") BooksServiceImpl booksService)
    {
        this.booksService = booksService;
    }

    @GetMapping
    public String viewByIdOrAll(Model model) {
        model.addAttribute("idForm", new Id());
        model.addAttribute("typeForm", new TypeForm());

        var furnitures = booksService.findAll();
        model.addAttribute("furnitures", furnitures);
        return "view";
    }

    @GetMapping(params = "id")
    public String viewByIdOrAll(@Valid IdForm idForm, BindingResult bindingResultIdForm, TypeForm typeForm, Model model) {
        if (bindingResultIdForm.hasErrors()) {
            return "view";
        }
        if (idForm.getId() == 0) {
            return "redirect:/view";
        }
        var furnitures = booksService.findById(idForm.getId()).stream().collect(Collectors.toList());
        model.addAttribute("furnitures", furnitures);
        return "view";
    }

    @GetMapping(params = "type")
    public String viewByType(@Valid TypeForm typeForm, BindingResult bindingResultTypeForm, IdForm idForm, Model model) {
        if (bindingResultTypeForm.hasErrors()) {
            return "view";
        }
        var furnitures = booksService.findByType(typeForm.getType());
        model.addAttribute("furnitures", furnitures);
        return "view";
    }
}
