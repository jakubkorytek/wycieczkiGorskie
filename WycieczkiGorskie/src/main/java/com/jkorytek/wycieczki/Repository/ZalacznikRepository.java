package com.jkorytek.wycieczki.Repository;

import com.jkorytek.wycieczki.Entity.Zalacznik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZalacznikRepository extends JpaRepository<Zalacznik,Long> {
    public Zalacznik findByIdZalacznika(Long id);


}
