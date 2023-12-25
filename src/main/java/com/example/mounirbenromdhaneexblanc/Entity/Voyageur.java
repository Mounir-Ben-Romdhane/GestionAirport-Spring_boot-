package com.example.mounirbenromdhaneexblanc.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "voyageur")
public class Voyageur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVoyageur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "dateNaissance")
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "voyageur")
    private Set<Reservation> reservations = new HashSet<>();
}
