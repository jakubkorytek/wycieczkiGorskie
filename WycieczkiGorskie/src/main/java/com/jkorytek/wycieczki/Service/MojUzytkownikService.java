package com.jkorytek.wycieczki.Service;


import com.jkorytek.wycieczki.Entity.Użytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.jkorytek.wycieczki.Security.MojUzytkownik;

@Service
public class MojUzytkownikService implements UserDetailsService {

    private UzytkownikService uzytkownikService;

    @Autowired
    public MojUzytkownikService(UzytkownikService uzytkownikService) {
        this.uzytkownikService = uzytkownikService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Użytkownik użytkownik = uzytkownikService.findUserByName(s);
        if (użytkownik != null) {
            return new MojUzytkownik(użytkownik);
        } else {
            throw new UsernameNotFoundException("User with name " + s + " not found");
        }
    }
}