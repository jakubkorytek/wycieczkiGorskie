package com.jkorytek.wycieczki.Controller;

import com.jkorytek.wycieczki.Entity.Zalacznik;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.jkorytek.wycieczki.Service.ZalacznikService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class ZalacznikController {

    ZalacznikService zalacznikService;

    public ZalacznikController(ZalacznikService zalacznikService) {
        this.zalacznikService = zalacznikService;
    }
    @GetMapping("zalączniki/{id}")
    public byte[] zdjecie(@PathVariable String id) throws IOException {
        Zalacznik zalacznik = zalacznikService.findById(Long.parseLong(id));
        System.out.println(zalacznik);
        File file = new File(zalacznik.getDiscPath());
        System.out.println(file);
        return Files.readAllBytes(file.toPath());
    }
}
