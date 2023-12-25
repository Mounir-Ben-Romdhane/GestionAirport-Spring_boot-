package com.example.mounirbenromdhaneexblanc.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "declaration")
public class Declaration {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "dateDeclaration")
    private LocalDate dateDeclaration;

    @Column(name = "estTraitee")
    private boolean estTraitee;

    @Column(name = "dateTraitement")
    private LocalDate dateTraitement;

    @Column(name = "description")
    private String description;

    //relation bidirectionnelle entre declaration et utilisateur
    @ManyToOne
    @JsonIgnore
    Utilisateur victime;

    //relation bidirectionnelle entre declaration et utilisateur
    @ManyToOne
    @JsonIgnore
    Utilisateur policier;

    //relation uni directionnelle entre declaration et propriete
    @OneToOne
    Propriete propriete;
}
