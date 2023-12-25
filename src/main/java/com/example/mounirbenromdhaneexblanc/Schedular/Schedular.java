package com.example.mounirbenromdhaneexblanc.Schedular;


import com.example.mounirbenromdhaneexblanc.Service.Vol.IVolService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class Schedular {

    @Autowired
    IVolService iVolService;

    /*@Scheduled(fixedRate = 2000)
    void affiche(){
        log.info("Bonjour");
    }*/

    @Scheduled(fixedRate = 60000)
    void annulerReservation(){
        iVolService.AnnulerReservations();
    }

    /*@Scheduled(fixedRate = 60000)
    void listeChambreParBloc() {
        List<Bloc> blocs = iBlocService.findAll();
        for (Bloc bloc:
             blocs) {
            log.info("Bloc => "+bloc.getNomBloc() + " ayant une capacité : "+ bloc.getCapaciteBloc());
            log.info("la liste des chamres pour ce bloc : ");
            for (Chambre c:
                 bloc.getChambres()) {
                log.info("Num chambre : "+c.getNumeroChambre()+" Type : "+ c.getTypeChambre());
            }
            log.info("***************************");
        }
    }*/

    /*
    @Scheduled(fixedRate = 300000)
    void pourcentageChambreParTypeChambre(){
        List<Chambre> chambres = iChambreService.findAll();


        float totale = chambres.size();
        float totalSimple = chambreRepository.findByTypeChambre(TypeChambre.SIMPLE).size();
        float totalDouple = chambreRepository.findByTypeChambre(TypeChambre.DOUBLE).size();
        float totalTriple = chambreRepository.findByTypeChambre(TypeChambre.TRIPLE).size();

        log.info("Nombre total des chambres : "+totale);
        log.info("Le pourcentage des chambres pour le type SIMPLE est egale a "+(totalSimple/totale)*100 +"%");
        log.info("Le pourcentage des chambres pour le type DOUBLE est egale a "+(totalDouple/totale)*100+"%");
        log.info("Le pourcentage des chambres pour le type TRIPLE est egale a "+(totalTriple/totale)*100+"%");
        log.info("***************************");
    } */


}
