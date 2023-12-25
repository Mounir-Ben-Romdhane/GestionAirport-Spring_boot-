package com.example.mounirbenromdhaneexblanc.Service.Declaration;

import com.example.mounirbenromdhaneexblanc.Entity.Declaration;
import com.example.mounirbenromdhaneexblanc.Entity.Utilisateur;
import com.example.mounirbenromdhaneexblanc.Repository.DeclarationRepository;
import com.example.mounirbenromdhaneexblanc.Repository.ProprieteRepository;
import com.example.mounirbenromdhaneexblanc.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class DeclarationService implements IDeclarationService{

    @Autowired
    DeclarationRepository declarationRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ProprieteRepository proprieteRepository;
    @Override
    public String ajouterDeclarationEtAffecterAVictime(Declaration declaration, String telephone) {
        //suivante, ajouter la déclaration de vol et sa propriété
        //ci-dessous et l’affecter à la victime
        //test si le telephone existe dans la base de donnée
        if (utilisateurRepository.findByTelephone(telephone) != null) {
            declaration.setVictime(utilisateurRepository.findByTelephone(telephone));
            proprieteRepository.save(declaration.getPropriete());
            declarationRepository.save(declaration);
            return "declaration ajouté avec succès";
        }
        return null;
    }

    @Override
    public void affecterPolicierADeclarataion(long idUtilisateur, long idDeclarataion) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur);
        System.out.println(utilisateur);
        Declaration declaration = declarationRepository.findById(idDeclarataion);
        System.out.println(declaration);
        declaration.setPolicier(utilisateur);
        declarationRepository.save(declaration);
    }


    public void traiterDeclarationAutomatiquement() {
        LocalDate currentDate = LocalDate.now();

        // Retrieve declarations that are over a month old and not treated
        List<Declaration> declarationsAtraiter = declarationRepository.findByEstTraiteeFalseAndDateDeclarationBefore(currentDate.minusMonths(1));

        for (Declaration declaration : declarationsAtraiter) {
            // Traitement de la déclaration
            declaration.setEstTraitee(true);
            declaration.setDateTraitement(currentDate);

            // Vous pouvez ajouter d'autres actions de traitement si nécessaire
        }

        // Enregistrez les modifications dans la base de données si nécessaire
        declarationRepository.saveAll(declarationsAtraiter);
    }
}
