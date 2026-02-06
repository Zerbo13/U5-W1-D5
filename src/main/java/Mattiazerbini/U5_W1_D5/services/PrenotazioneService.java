package Mattiazerbini.U5_W1_D5.services;

import Mattiazerbini.U5_W1_D5.entitites.Edificio;
import Mattiazerbini.U5_W1_D5.entitites.Postazione;
import Mattiazerbini.U5_W1_D5.entitites.Prenotazione;
import Mattiazerbini.U5_W1_D5.exceptions.ValidationException;
import Mattiazerbini.U5_W1_D5.repositories.EdificioRepository;
import Mattiazerbini.U5_W1_D5.repositories.PostazioneRepository;
import Mattiazerbini.U5_W1_D5.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository){
        this.prenotazioneRepository = prenotazioneRepository;
    }
    public void salvaPostazione(Prenotazione newPrenotazione){
        if(prenotazioneRepository.existsById((newPrenotazione.getId())))
            throw  new ValidationException("Questa postazione " +newPrenotazione.getId()+ " è gia registrata");
        this.prenotazioneRepository.save(newPrenotazione);
        log.info("La prenotazione " +newPrenotazione.getId()+" è stato salvato!");
    }
}
