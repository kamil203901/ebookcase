package pl.kazmierczak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

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
    public String successLogin(ModelMap model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "home";
    }

    @PostMapping("/login/failure")
    public String failureLogin() {
        return "login";
    }

}
