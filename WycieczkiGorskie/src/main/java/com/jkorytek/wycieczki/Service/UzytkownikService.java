package com.jkorytek.wycieczki.Service;

import com.jkorytek.wycieczki.Entity.Użytkownik;
import com.jkorytek.wycieczki.Repository.UzytkownikRepository;
import org.springframework.stereotype.Service;

@Service
public class UzytkownikService {
    private UzytkownikRepository uzytkownikRepository;

    public UzytkownikService(UzytkownikRepository uzytkownikRepository) {
        this.uzytkownikRepository = uzytkownikRepository;
    }
    public Użytkownik findUserByName(String name){
        return uzytkownikRepository.findByLogin(name);
    }
    public Użytkownik findUserByLogin(String name) { return uzytkownikRepository.findByLogin(name);}
    public void saveUser(Użytkownik użytkownik){ uzytkownikRepository.save(użytkownik);}
}