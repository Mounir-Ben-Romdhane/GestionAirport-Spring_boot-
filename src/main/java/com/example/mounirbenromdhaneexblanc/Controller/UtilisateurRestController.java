package com.example.mounirbenromdhaneexblanc.Controller;

import com.example.mounirbenromdhaneexblanc.Entity.Utilisateur;
import com.example.mounirbenromdhaneexblanc.Service.Utilisateur.IUtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("utilisateur")
public class UtilisateurRestController {

    @Autowired
    IUtilisateurService iUtilisateurService;

    //ajout d'un utilisateur
    @PostMapping("/ajouterVictime")
    Utilisateur ajouterVictime(@RequestBody Utilisateur victime){
        return iUtilisateurService.ajouterVictime(victime);
    }

    @PostMapping("/ajouterPoliciers")
    String ajouterPoliciers(@RequestBody List<Utilisateur> policiers){
        return iUtilisateurService.ajouterPoliciers(policiers);
    }
}
