package com.jkorytek.wycieczki.Service;

import com.jkorytek.wycieczki.Entity.Zalacznik;
import com.jkorytek.wycieczki.Entity.Wycieczka;
import com.jkorytek.wycieczki.Repository.ZalacznikRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ZalacznikService {
    String FOLDER = "src\\main\\resources\\załączniki\\";

    ZalacznikRepository zalacznikRepository;

    public ZalacznikService(ZalacznikRepository zalacznikRepository) {
        this.zalacznikRepository = zalacznikRepository;
    }

    private void dodaj(Wycieczka wycieczka, Path path){
        Zalacznik multimedia = new Zalacznik(wycieczka.getIdWycieczki(),path.toString());
        zalacznikRepository.save(multimedia);
    }


    public void dodajZalacznik(Wycieczka wycieczka, MultipartFile file) {
        try {
            Path path = Paths.get(FOLDER + wycieczka.getIdWycieczki() + file.getOriginalFilename());
            Files.write(path, file.getBytes());
            dodaj(wycieczka,path);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Zalacznik findById(Long id){
        return zalacznikRepository.findByIdZalacznika(id);
    }



    public List<Zalacznik> findAll(){
        return zalacznikRepository.findAll();
    }
}
