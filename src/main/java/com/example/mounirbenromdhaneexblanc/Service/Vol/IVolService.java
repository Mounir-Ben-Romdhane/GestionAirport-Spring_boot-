package com.example.mounirbenromdhaneexblanc.Service.Vol;

import com.example.mounirbenromdhaneexblanc.Entity.ClassPlace;
import com.example.mounirbenromdhaneexblanc.Entity.Reservation;
import com.example.mounirbenromdhaneexblanc.Entity.Vol;
import com.example.mounirbenromdhaneexblanc.Entity.Voyageur;

import java.util.List;
import java.util.Map;

public interface IVolService {
    String ajouterVolEtAeroport(Vol vol);

    List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs);

    String reserverVol(long voyegeurId, long volId, ClassPlace classPlace);

    Reservation confirmerReservation(String resIs);

    Map<Long, List<Voyageur>> getVoyageursByVol();

    void AnnulerReservations();
}
