package com.example.mounirbenromdhaneexblanc.Service.Utilisateur;

import com.example.mounirbenromdhaneexblanc.Entity.Utilisateur;

import java.util.List;

public interface IUtilisateurService {
    //ajout d'un utilisateur
    Utilisateur ajouterVictime(Utilisateur utilisateur);

    String ajouterPoliciers(List<Utilisateur> policiers) ;
}
