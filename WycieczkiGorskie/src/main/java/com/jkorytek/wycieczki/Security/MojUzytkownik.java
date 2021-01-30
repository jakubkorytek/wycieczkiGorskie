package com.jkorytek.wycieczki.Security;


import com.jkorytek.wycieczki.Entity.Użytkownik;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MojUzytkownik implements UserDetails {

    private Użytkownik użytkownik;

    public MojUzytkownik(Użytkownik użytkownik) {
        this.użytkownik = użytkownik;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grants = new ArrayList<>();
        grants.add(new SimpleGrantedAuthority("ROLE_" + użytkownik.getRole()));
        return grants;
    }

    @Override
    public String getPassword() {
        return użytkownik.getHaslo();
    }

    @Override
    public String getUsername() {
        return użytkownik.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}