package com.example.mounirbenromdhaneexblanc.Repository;

import com.example.mounirbenromdhaneexblanc.Entity.EtatReservation;
import com.example.mounirbenromdhaneexblanc.Entity.Vol;
import com.example.mounirbenromdhaneexblanc.Entity.Voyageur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VoyageurRepo extends JpaRepository<Voyageur, Long> {

    List<Voyageur> findByReservationsEtatReservationAndReservationsVolAndReservationsDateReservation(EtatReservation etatReservation, Vol vol, LocalDate dateReservation);
}
