package com.example.mounirbenromdhaneexblanc.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "vol")
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVol;

    @Column(name = "dateDepart")
    private LocalDate dateDepart;

    @Column(name = "dateArrive")
    private LocalDate dateArrive;

    @ManyToOne
    private Aeroport aeroportDepart;

    @ManyToOne
    private Aeroport aeroportArrivee;

    @OneToMany(mappedBy = "vol")
    private Set<Reservation> reservations = new HashSet<>();




}
