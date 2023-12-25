package com.example.mounirbenromdhaneexblanc.Controller;

import com.example.mounirbenromdhaneexblanc.Entity.ClassPlace;
import com.example.mounirbenromdhaneexblanc.Entity.Reservation;
import com.example.mounirbenromdhaneexblanc.Entity.Vol;
import com.example.mounirbenromdhaneexblanc.Entity.Voyageur;
import com.example.mounirbenromdhaneexblanc.Service.Vol.IVolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("vol")
public class VolController {

    @Autowired
    IVolService iVolService;

    @PostMapping("/ajouterVol")
    String ajouterVol(@RequestBody Vol vol){
        return iVolService.ajouterVolEtAeroport(vol);
    }

    @PostMapping("/ajouterVoyageurs")
    List<Voyageur> ajouterVoyageurs(@RequestBody List<Voyageur> voyageurs){
        return iVolService.ajouterVoyageurs(voyageurs);
    }

    @PostMapping("/reserverVol")
    String reserverVol(@RequestParam long voyegeurId, @RequestParam long volId,@RequestParam ClassPlace classPlace){
        return iVolService.reserverVol(voyegeurId, volId, classPlace);
    }

    @PutMapping("/confirmerReservation")
    Reservation confirmerReservation(@RequestParam String idReservation){
        return iVolService.confirmerReservation(idReservation);
    }

    @GetMapping("/getReservationByVoyageur")
    Map<Long, List<Voyageur>> getReservationByVoyageur(){
        return iVolService.getVoyageursByVol();
    }
}
