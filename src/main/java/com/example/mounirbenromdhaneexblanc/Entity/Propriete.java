package com.example.mounirbenromdhaneexblanc.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "propriete")
public class Propriete {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "typePropriete")
    private TypePropriete typePropriete;

    @Column(name = "coleur")
    private String coleur;

    @Column(name = "marque")
    private String marque;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "numSerie")
    private String numSerie;



}
