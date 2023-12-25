package com.example.mounirbenromdhaneexblanc.Service.Declaration;

import com.example.mounirbenromdhaneexblanc.Entity.Declaration;

public interface IDeclarationService {
    String ajouterDeclarationEtAffecterAVictime(Declaration declaration, String telephone) ;

    void affecterPolicierADeclarataion(long idUtilisateur, long idDeclarataion);

    void traiterDeclarationAutomatiquement();
}
