package com.example.mounirbenromdhaneexblanc.Service.Utilisateur;

import com.example.mounirbenromdhaneexblanc.Entity.Utilisateur;
import com.example.mounirbenromdhaneexblanc.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService implements IUtilisateurService{

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur ajouterVictime(Utilisateur utilisateur) {
        //test si role est victime on ajout sinon on returne un objet vide
        if (utilisateur.getRole().toString() == "POLICIER") {
            return new Utilisateur();
        }
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public String ajouterPoliciers(List<Utilisateur> policiers) {
        //JSON. La méthode retourne un message qui respecte le format suivant : « (Nombre de policier ajouté) policiers sont ajoutés avec succès
        utilisateurRepository.saveAll(policiers);
        return policiers.size()+" policiers sont ajoutés avec succès !";
    }
}
