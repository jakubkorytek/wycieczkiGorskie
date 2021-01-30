package com.jkorytek.wycieczki.Controller;

import com.jkorytek.wycieczki.Entity.Zalacznik;
import com.jkorytek.wycieczki.Entity.Użytkownik;
import com.jkorytek.wycieczki.Entity.Wycieczka;
import com.jkorytek.wycieczki.Repository.WycieczkaRepository;
import com.jkorytek.wycieczki.Service.ZalacznikService;
import com.jkorytek.wycieczki.Service.UzytkownikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.*;

@Controller
public class WycieczkiController {


    WycieczkaRepository wycieczkaRepository;
    ZalacznikService zalacznikService;
    UzytkownikService uzytkownikService;


    public WycieczkiController(WycieczkaRepository wycieczkaRepository, ZalacznikService zalacznikService, UzytkownikService uzytkownikService) {
        this.wycieczkaRepository = wycieczkaRepository;
        this.zalacznikService = zalacznikService;
        this.uzytkownikService = uzytkownikService;
    }

    @GetMapping("/Wycieczki/{id}")
    public String getDetails(@PathVariable String id, Model model) {
        Wycieczka wycieczka = wycieczkaRepository.findByIdWycieczki(Long.parseLong(id));
        model.addAttribute("wycieczka", wycieczka);
        List<Zalacznik> zdjecia = zalacznikService.findAll();

        List<Zalacznik> zd = new ArrayList<>();
        for (Zalacznik z : zdjecia) {
            if (z.getIdWycieczki().equals(wycieczka.getIdWycieczki())) {
                zd.add(z);
            }
        }

        if (zd.stream().count() == 6) {
            model.addAttribute("button", false);
        } else {
            model.addAttribute("button", true);
        }
        model.addAttribute("zdjecia", zd);
        return "Wycieczki/Szczegoly";
    }

    @GetMapping("/Wycieczki/ListaWycieczek")
    public String getList(Model model,Principal principal) {
        List<Wycieczka> wycieczkaList = wycieczkaRepository.findAll();

        model.addAttribute("data", wycieczkaList);
        if(principal!=null) {
            Użytkownik użytkownik = uzytkownikService.findUserByName(principal.getName());
            model.addAttribute("user", użytkownik);
        } else {
            model.addAttribute("user",new Użytkownik());
        }
        return "Wycieczki/ListaWycieczek";
    }


    @PostMapping("/Wycieczki/DodajZdjecie")
    public RedirectView dodajZdjecie(@RequestParam("file") MultipartFile file, @ModelAttribute("Wycieczka") Wycieczka wycieczka) {

        if (!file.isEmpty()) {
            zalacznikService.dodajZalacznik(wycieczka, file);
        }
        return new RedirectView("/Wycieczki/"+wycieczka.getIdWycieczki());
    }

    @GetMapping("/Wycieczki/DodajWycieczke")
    public String addRecipe(Model model) {
        model.addAttribute("Wycieczka", new Wycieczka());
        return "Wycieczki/DodajWycieczke";
    }

    @PostMapping("/Wycieczki/DodajWycieczke")
    public RedirectView dodajWycieczke(@ModelAttribute("Wycieczka") Wycieczka wycieczka, Principal principal) {
        Użytkownik użytkownik = uzytkownikService.findUserByName(principal.getName());
        wycieczka.setIdUzytkownika(użytkownik.getIdUser());
        wycieczkaRepository.save(wycieczka);

        return new RedirectView("/index");
    }


}



