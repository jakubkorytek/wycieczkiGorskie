package com.jkorytek.wycieczki.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Użytkownik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long IdUser;

    String haslo;
    String login;
    String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Użytkownik(String haslo, String login, String role) {
        this.haslo = haslo;
        this.login = login;
        this.role = role;
    }

    public Użytkownik() {
    }

    public Long getIdUser() {
        return IdUser;
    }

    public void setIdUser(Long IDuser) {
        this.IdUser = IDuser;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
