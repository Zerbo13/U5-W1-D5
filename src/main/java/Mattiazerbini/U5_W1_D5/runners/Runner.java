package Mattiazerbini.U5_W1_D5.runners;

import Mattiazerbini.U5_W1_D5.entitites.*;
import Mattiazerbini.U5_W1_D5.services.EdificioService;
import Mattiazerbini.U5_W1_D5.services.PostazioneService;
import Mattiazerbini.U5_W1_D5.services.PrenotazioneService;
import Mattiazerbini.U5_W1_D5.services.UtenteService;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

    private final UtenteService uService;
    private final PostazioneService pService;
    private final PrenotazioneService prService;
    private final EdificioService eService;

    public Runner(UtenteService uService, PostazioneService pService, PrenotazioneService prService, EdificioService eService) {
        this.uService = uService;
        this.pService = pService;
        this.prService = prService;
        this.eService = eService;
    }

    @Override
    public void run(String... args)throws Exception{

        Edificio e1 = new Edificio("Sede Primaria", "Via Roma", "Milano");
        Edificio e2 = new Edificio("Sede Secondaria", "Via Napoli", "Torino");
        Edificio e3 = new Edificio("Sede Centrale", "Via Milano", "Palermo");

        eService.salvaEdificio(e1);
        eService.salvaEdificio(e2);
        eService.salvaEdificio(e3);

        Postazione p1 = new Postazione(123, "Colloquio", Tipo.PRIVATO, 2, e2);
        Postazione p2 = new Postazione(456, "Riunione aziendale", Tipo.SALA_RIUNIONI, 20, e3);
        Postazione p3 = new Postazione(789, "Presentazione progetto", Tipo.OPENSPACE, 70, e1);

        pService.salvaPostazione(p1);
        pService.salvaPostazione(p2);
        pService.salvaPostazione(p3);

        Utente u1 = new Utente("Mario1970", "Mario", "Rossi", "MarioRossi@gmail.com");
        Utente u2 = new Utente("RolBia33", "Rolando", "Bianchi", "Rolandobianchi@gmail.com");
        Utente u3 = new Utente("Gatto50", "Andrea", "Verdi", "VerdiAndrea@gmail.com");

        uService.salvaUtente(u1);
        uService.salvaUtente(u2);
        uService.salvaUtente(u3);

        Prenotazione pr1 = new Prenotazione(LocalDate.now(), p1, u3 );
        Prenotazione pr2 = new Prenotazione(LocalDate.of(2025,02,12), p3, u2 );
        Prenotazione pr3 = new Prenotazione(LocalDate.of(2025,03,12), p2, u1 );

        prService.salvaPrenotazione(pr1);
        prService.salvaPrenotazione(pr2);
        prService.salvaPrenotazione(pr3);
    }
}
