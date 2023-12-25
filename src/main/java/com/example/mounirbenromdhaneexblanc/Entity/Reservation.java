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
@Table(name = "reservation")
public class Reservation {

    @Id
    private String idReservation;

    @Column(name = "dateReservation")
    private LocalDate dateReservation;

    @Column(name = "classPlace")
    @Enumerated(EnumType.STRING)
    private ClassPlace classPlace;

    @Column(name = "etatReservation")
    @Enumerated(EnumType.STRING)
    private EtatReservation etatReservation;

    @ManyToOne
    @JsonIgnore
    private Vol vol;

    @ManyToOne
    @JsonIgnore
    private Voyageur voyageur;

}
