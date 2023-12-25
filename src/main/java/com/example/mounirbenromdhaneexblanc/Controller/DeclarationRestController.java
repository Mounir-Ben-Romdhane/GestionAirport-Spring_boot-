package com.example.mounirbenromdhaneexblanc.Controller;


import com.example.mounirbenromdhaneexblanc.Entity.Declaration;
import com.example.mounirbenromdhaneexblanc.Service.Declaration.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("declaration")
public class DeclarationRestController {

    @Autowired
    IDeclarationService iDeclarationService;

    @PostMapping("/ajouterDeclaration")
    String ajouterDeclaration(@RequestBody Declaration declaration, @RequestParam String telephone){
        return iDeclarationService.ajouterDeclarationEtAffecterAVictime(declaration, telephone);
    }

    @PutMapping("/affecterPolicierADeclarataion")
    void affecterPolicierADeclarataion(@RequestParam long idUtilisateur, @RequestParam long idDeclarataion){
        iDeclarationService.affecterPolicierADeclarataion(idUtilisateur, idDeclarataion);
    }

    @GetMapping("/traiterDeclarationAutomatiquement")
    void traiterDeclarationAutomatiquement(){
        iDeclarationService.traiterDeclarationAutomatiquement();
    }
}
