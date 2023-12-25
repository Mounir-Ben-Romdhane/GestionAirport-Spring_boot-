package com.example.mounirbenromdhaneexblanc.Repository;

import com.example.mounirbenromdhaneexblanc.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByTelephone(String telephone);

    Utilisateur findById(long id);
}
