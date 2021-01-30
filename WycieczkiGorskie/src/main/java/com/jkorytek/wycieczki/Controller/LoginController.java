package com.jkorytek.wycieczki.Controller;


import com.jkorytek.wycieczki.Entity.Użytkownik;
import com.jkorytek.wycieczki.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    UzytkownikService uzytkownikService;

    @Autowired
    public LoginController(UzytkownikService uzytkownikService) {
        this.uzytkownikService = uzytkownikService;
    }

    @GetMapping("/login")
    public String login() {
        return "/Logowanie/Login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/Logowanie/Login";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("uzytkownik", new Użytkownik());
        return "/Logowanie/SignUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("uzytkownik") Użytkownik użytkownik) {
        if (uzytkownikService.findUserByLogin(użytkownik.getLogin()) == null)
        {
            użytkownik.setRole("user");
            użytkownik.setHaslo(passwordEncoder().encode(użytkownik.getHaslo()));
            uzytkownikService.saveUser(użytkownik);
            return "index";
        } else {
            return "/Logowanie/SignUp";
        }
    }

    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
