package com.example.mounirbenromdhaneexblanc.Repository;

import com.example.mounirbenromdhaneexblanc.Entity.ClassPlace;
import com.example.mounirbenromdhaneexblanc.Entity.EtatReservation;
import com.example.mounirbenromdhaneexblanc.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, String> {
    List<Reservation> findByClassPlace(ClassPlace classPlace);

    List<Reservation> findByEtatReservation(EtatReservation etatReservation);
}
