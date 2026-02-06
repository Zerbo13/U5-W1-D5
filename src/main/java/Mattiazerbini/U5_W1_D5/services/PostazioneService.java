package Mattiazerbini.U5_W1_D5.services;

import Mattiazerbini.U5_W1_D5.entitites.Postazione;
import Mattiazerbini.U5_W1_D5.exceptions.ValidationException;
import Mattiazerbini.U5_W1_D5.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostazioneService {

    private final PostazioneRepository postazioneRepository;

    @Autowired
    public PostazioneService(PostazioneRepository postazioneRepository){
        this.postazioneRepository = postazioneRepository;
    }

    public void salvaPostazione(Postazione newPostazione){
        if(postazioneRepository.existsByCodice_univoco((newPostazione.getCodice_univoco())))
            throw  new ValidationException("Questa postazione " +newPostazione.getCodice_univoco()+ " è gia registrata");
        this.postazioneRepository.save(newPostazione);
        log.info("La postazione " +newPostazione.getCodice_univoco()+" è stato salvato!");
    }
}
