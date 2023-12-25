package com.example.mounirbenromdhaneexblanc.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    //relation bidirectionnelle entre declaration et utilisateur one to many
    @OneToMany(mappedBy = "victime")
    private Set<Declaration> declarationVictime = new HashSet<>();

    //relation bidirectionnelle entre declaration et utilisateur one to many
    @OneToMany(mappedBy = "policier")
    private Set<Declaration> declarationPolicier = new HashSet<>();




}
