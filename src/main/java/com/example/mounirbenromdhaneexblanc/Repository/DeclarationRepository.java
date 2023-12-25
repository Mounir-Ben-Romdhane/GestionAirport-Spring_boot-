package com.example.mounirbenromdhaneexblanc.Repository;

import com.example.mounirbenromdhaneexblanc.Entity.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DeclarationRepository extends JpaRepository<Declaration, Long> {
    Declaration findById(long id);

    List<Declaration> findByEstTraiteeFalse();

    List<Declaration> findByEstTraiteeFalseAndDateDeclarationBefore(LocalDate dateTraitement);
}
