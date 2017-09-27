package pl.kazmierczak.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import pl.kazmierczak.domain.Reader;
import pl.kazmierczak.repositories.ReaderRepository;
import pl.kazmierczak.services.ReaderServiceImpl;

import javax.validation.Valid;

@Controller
public class ReaderController {
    @Autowired
    private ReaderServiceImpl readerService;

    @GetMapping("/register")
    public ModelAndView showForm() {
        return new ModelAndView("register", "reader", new Reader());
    }

    @PostMapping("/register")
    public String submitReader(@Valid @ModelAttribute("reader")Reader reader,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }

        readerService.saveOrUpdate(reader);



        return "readerView";
    }

}
