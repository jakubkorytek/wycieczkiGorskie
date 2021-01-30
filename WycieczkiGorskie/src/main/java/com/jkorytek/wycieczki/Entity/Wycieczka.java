package com.jkorytek.wycieczki.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wycieczka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idWycieczki;

    String miejscowosc;
    String start;
    String meta;
    String dataWycieczki;
    int liczbaDni;
    float liczbaKilometrow;

    long idUzytkownika;

    public void setIdUzytkownika(long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Long getIdWycieczki() {
        return idWycieczki;
    }

    public void setIdWycieczki(Long idWycieczki) {
        this.idWycieczki = idWycieczki;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getMeta() {
        return meta;
    }

    public float getLiczbaKilometrow() {
        return liczbaKilometrow;
    }

    public long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String wojewodztwo) {
        this.miejscowosc = wojewodztwo;
    }

    public String getDataWycieczki() {
        return dataWycieczki;
    }

    public void setDataWycieczki(String data) {
        String[] e = data.split(" ");
        this.dataWycieczki = e[0];
    }

    public int getLiczbaDni() {
        return liczbaDni;
    }

    public void setLiczbaDni(int liczbaDni) {
        this.liczbaDni = liczbaDni;
    }

    public void setLiczbaKilometrow(float liczbaKilometrow) {
        this.liczbaKilometrow = liczbaKilometrow;
    }


    public void setLiczbaKilometrow(int dlugosc) {
        this.liczbaKilometrow = dlugosc;
    }

    public Wycieczka(String start, String meta, String miejscowosc, String dataWycieczki, int liczbaDni, float liczbaKilometrow) {
        this.start = start;
        this.meta = meta;
        this.miejscowosc = miejscowosc;
        this.dataWycieczki = dataWycieczki;
        this.liczbaKilometrow = liczbaKilometrow;
        this.liczbaDni = liczbaDni;
    }

    public Wycieczka() {
    }
}
