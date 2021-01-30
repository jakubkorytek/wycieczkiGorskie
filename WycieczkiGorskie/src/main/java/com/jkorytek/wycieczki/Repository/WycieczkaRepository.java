package com.jkorytek.wycieczki.Repository;

import com.jkorytek.wycieczki.Entity.Wycieczka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WycieczkaRepository extends JpaRepository<Wycieczka, Long> {
    Wycieczka findByIdWycieczki(long id);
}
