package com.jkorytek.wycieczki.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zalacznik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idZalacznika;

    Long IdWycieczki;

    String discPath;

    public Zalacznik(Long idWycieczki, String discPath) {
        IdWycieczki = idWycieczki;
        this.discPath = discPath;
    }

    public Zalacznik() {
    }

    public Long getIdZalacznika() {
        return idZalacznika;
    }

    public void setIdZalacznika(Long idMultimedi) {
        this.idZalacznika = idMultimedi;
    }

    public Long getIdWycieczki() {
        return IdWycieczki;
    }

    public void setIdWycieczki(Long idWycieczki) {
        IdWycieczki = idWycieczki;
    }

    public String getDiscPath() {
        return discPath;
    }

    public void setDiscPath(String lokalizacja) {
        this.discPath = lokalizacja;
    }
}
