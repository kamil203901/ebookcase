package pl.kazmierczak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @RequestMapping("/")
    public String redirToLogin() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String home() {
        return "main";
    }

    @GetMapping("/newauthor")
    public String newAuthor() {
        return "newAuthor";
    }

    @GetMapping("/login")
    public String logging() {
        return "login";
    }

    @PostMapping("/login/success")
    public String successLogin() {
        return "home";
    }

    @PostMapping("/login/failure")
    public String failureLogin() {
        return "login";
    }

}
