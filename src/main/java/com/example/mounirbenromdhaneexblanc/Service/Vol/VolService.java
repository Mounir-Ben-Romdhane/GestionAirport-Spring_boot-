package com.example.mounirbenromdhaneexblanc.Service.Vol;

import com.example.mounirbenromdhaneexblanc.Entity.*;
import com.example.mounirbenromdhaneexblanc.Repository.AeroportRepo;
import com.example.mounirbenromdhaneexblanc.Repository.ReservationRepo;
import com.example.mounirbenromdhaneexblanc.Repository.VolRepository;
import com.example.mounirbenromdhaneexblanc.Repository.VoyageurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VolService implements IVolService {

    @Autowired
    VolRepository volRepository;

    @Autowired
    AeroportRepo aeroportRepo;

    @Autowired
    VoyageurRepo voyageurRepo;

    @Autowired
    ReservationRepo reservationRepo;
    @Override
    public String ajouterVolEtAeroport(Vol vol) {
        //test si code AITA de aeroport depart la meme de aeroport arrive
        if(vol.getAeroportDepart().getCodeAITA().equals(vol.getAeroportArrivee().getCodeAITA()))
            return "Vérifier les aéroports saisis!";
        aeroportRepo.save(vol.getAeroportArrivee());
        aeroportRepo.save(vol.getAeroportDepart());
        volRepository.save(vol);
        return "Vol ajouté avec succès!";
    }

    @Override
    public List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs) {
        return voyageurRepo.saveAll(voyageurs);
    }

    @Override
    public String reserverVol(long voyegeurId, long volId, ClassPlace classPlace) {
        Reservation reservation = new Reservation();
        Voyageur voyageur = voyageurRepo.findById(voyegeurId).get();
        Vol vol = volRepository.findById(volId).get();
        String msg = "";
        //ld.substring(0, 1)
        String idRes = ""+classPlace.toString().substring(0, 3) +"-"+ vol.getIdVol()+ "-"+voyageur.getIdVoyageur() ;
        reservation.setIdReservation(idRes);
        reservation.setDateReservation(LocalDate.now());
        reservation.setEtatReservation(EtatReservation.ENCOURS);
        reservation.setClassPlace(classPlace);
        reservation.setVoyageur(voyageur);
        reservation.setVol(vol);
        //vol.getReservations().add(reservation);
        List<Reservation> reservations = reservationRepo.findByClassPlace(classPlace);
        int nbPlace = reservations.size();
        if(classPlace.equals(ClassPlace.BUSINESS)){
            if(nbPlace <2){
                reservationRepo.save(reservation);
                msg = "Réservation ajoutée avec succès avec Id res : " + idRes;
            }else msg= "La classe "+classPlace.toString()+" du vol "+ volId+" est complet!";
        } else if (classPlace.equals(ClassPlace.ECONOMIQUE)){
            if(nbPlace <3){
                reservationRepo.save(reservation);
                msg = "Réservation ajoutée avec succès avec Id res : " + idRes;
            }else msg = "La classe "+classPlace.toString()+" du vol "+ volId+" est complet!";
        }
        return msg;
    }

    @Override
    public Reservation confirmerReservation(String resId) {
        Reservation reservation = reservationRepo.findById(resId).get();
        reservation.setEtatReservation(EtatReservation.CONFIRME);
        return reservationRepo.save(reservation);
    }

    @Override
    public Map<Long, List<Voyageur>> getVoyageursByVol() {
        List<Vol> vols = volRepository.findAll();
        Map<Long, List<Voyageur>> voyageurs = new HashMap<>();
        for (Vol vol : vols) {
            List<Voyageur> voyageursByVol = voyageurRepo.findByReservationsEtatReservationAndReservationsVolAndReservationsDateReservation(EtatReservation.CONFIRME, vol, LocalDate.now());
            voyageurs.put(vol.getIdVol(), voyageursByVol);
        }
        return voyageurs;
    }

    @Override
    public void AnnulerReservations() {
        List<Reservation> reservations = reservationRepo.findByEtatReservation(EtatReservation.ENCOURS);
        for (Reservation reservation : reservations) {
            reservation.setEtatReservation(EtatReservation.ANNULEE);
            reservationRepo.save(reservation);
        }
    }
}
