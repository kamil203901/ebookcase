package pl.kazmierczak.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import pl.kazmierczak.domain.Reader;
import pl.kazmierczak.repositories.ReaderRepository;
import pl.kazmierczak.services.PasswordHelper;
import pl.kazmierczak.services.ReaderServiceImpl;

import javax.validation.Valid;

@Controller
public class ReaderController {
    @Autowired
    private ReaderServiceImpl readerService;
    @Autowired
    private PasswordHelper passwordsHelper;

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



    //todo: przejrzec to na spokojnie

   /* @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String checkPersonInfo(@Valid Reader reader, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors() || !processPasswords(reader, bindingResult)) {
            return "error";
        }
        return "home";
    }

    private boolean processPasswords(Reader reader, BindingResult bindingResult) {
        if (!reader.getPassword().equals(reader.getConfirmPassword())) {
            bindingResult.rejectValue("password", "Passwords don't match", "Passwords don't match");
            bindingResult.rejectValue("confirmPassword", "Passwords don't match", "Passwords don't match");
            return false;
        }
        reader.setPasswordSalt(passwordsHelper.getNextPasswordSeed());
        reader.setPasswordEncrypted(passwordsHelper.encrypt(reader.getPasswordSalt() + reader.getPassword()));
        return true;
    }*/

}
