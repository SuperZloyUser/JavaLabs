package ru.xorsiphus.controllers;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xorsiphus.dao.services.UserServiceImpl;
import ru.xorsiphus.entity.User;
import ru.xorsiphus.entity.UserRole;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.stream.Collectors;


@Controller
@RequestMapping
public class UserController
{
    private final UserServiceImpl userService;

    public UserController(@Qualifier("userService") UserServiceImpl UserService)
    {
        this.userService = UserService;
    }

    @GetMapping("/profile")
    public String getUserProfile(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user,
                                 Model model)
    {
        model.addAttribute("user", userService.findByUsername(user.getUsername()).orElse(new User()));
        model.addAttribute("springUser", user);
        boolean isAdmin = Arrays.asList(user.getAuthorities().toArray())
                .contains(new SimpleGrantedAuthority("ADMIN"));
        model.addAttribute("isAdmin", isAdmin);
        return "security/profile";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") User user)
    {
        return "security/registration";
    }

    @PostMapping("/registration")
    public String registerAnotherOne(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model)
    {
        boolean flag = false;

        if (userService.findByUsername(user.getUsername()).isPresent())
        {
            bindingResult.addError(new FieldError("user", "username", "Такой никнейм уже занят!"));
            var collector = Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage);
            var errors = bindingResult.getFieldErrors().stream().collect(collector);
            model.mergeAttributes(errors);
            flag = true;
        }

        if (user.getUsername().length() < 2 || user.getUsername().length() > 30)
        {
            bindingResult.addError(new FieldError("user", "username", "Некорректное имя пользователя (2-30 символов)"));
            var collector = Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage);
            var errors = bindingResult.getFieldErrors().stream().collect(collector);
            model.mergeAttributes(errors);
            flag = true;
        }

        if (!user.getPassword().equals(user.getRepeat_password()))
        {
            bindingResult.addError(new FieldError("user", "password", "Пароли не совпадают!"));
            var collector = Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage);
            var errors = bindingResult.getFieldErrors().stream().collect(collector);
            model.mergeAttributes(errors);
            flag = true;
        }

        if (user.getPassword().length() < 2 || user.getUsername().length() > 30)
        {
            bindingResult.addError(new FieldError("user", "password", "Некорректная длина пароля"));
            var collector = Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage);
            var errors = bindingResult.getFieldErrors().stream().collect(collector);
            model.mergeAttributes(errors);
            flag = true;
        }

        if (flag)
            return "security/registration";

        userService.insert(user);

        return "security/authentication";
    }

}
