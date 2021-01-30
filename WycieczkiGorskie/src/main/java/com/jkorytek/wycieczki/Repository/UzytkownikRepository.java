package com.jkorytek.wycieczki.Repository;


import com.jkorytek.wycieczki.Entity.Użytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzytkownikRepository extends JpaRepository<Użytkownik,Long> {
    Użytkownik findByLogin(String name);
}