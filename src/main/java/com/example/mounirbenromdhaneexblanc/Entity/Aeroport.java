package com.example.mounirbenromdhaneexblanc.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "aeroport")
public class Aeroport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAeroport;

    @Column(name = "nom")
    @NotNull
    private String nom;

    //codeAITA max length 3
    @Column(name = "codeAITA")
    @Size(max = 3, message = "{validation.codeAITA.size}")
    private String codeAITA;

    @Column(name = "telephone")
    private long telephone;

    //relation unidirectionnelle entre aeroport et vol one to many
    @OneToMany(mappedBy = "aeroportDepart")
    @JsonIgnore
    private Set<Vol> volsDepart = new HashSet<>();

    @OneToMany(mappedBy = "aeroportArrivee")
    @JsonIgnore
    private Set<Vol> volsArrivee = new HashSet<>();
}
