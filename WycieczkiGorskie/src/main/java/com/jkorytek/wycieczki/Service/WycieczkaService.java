package com.jkorytek.wycieczki.Service;

import org.springframework.stereotype.Service;
import com.jkorytek.wycieczki.Entity.Wycieczka;
import com.jkorytek.wycieczki.Repository.WycieczkaRepository;

@Service
public class WycieczkaService {
WycieczkaRepository wycieczkaRepository;

    public Wycieczka findByID(Long id){
        return wycieczkaRepository.findByIdWycieczki(id);

    }

}
