package Mattiazerbini.U5_W1_D5.services;

import Mattiazerbini.U5_W1_D5.entitites.Prenotazione;
import Mattiazerbini.U5_W1_D5.exceptions.NotfoundExcetion;
import Mattiazerbini.U5_W1_D5.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final PostazioneService postazioneService;
    private final UtenteService utenteService;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, PostazioneService postazioneService, UtenteService utenteService){
        this.prenotazioneRepository = prenotazioneRepository;
        this.postazioneService = postazioneService;
        this.utenteService = utenteService;
    }

    public void salvaPrenotazione(Prenotazione newPrenotazione){
        this.prenotazioneRepository.save(newPrenotazione);
        log.info("La postazione " +newPrenotazione.getId()+" è stato salvato!");
    }
}
