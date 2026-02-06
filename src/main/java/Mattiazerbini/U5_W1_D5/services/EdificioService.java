package Mattiazerbini.U5_W1_D5.services;

import Mattiazerbini.U5_W1_D5.entitites.Edificio;
import Mattiazerbini.U5_W1_D5.entitites.Postazione;
import Mattiazerbini.U5_W1_D5.entitites.Utente;
import Mattiazerbini.U5_W1_D5.exceptions.NotfoundExcetion;
import Mattiazerbini.U5_W1_D5.exceptions.ValidationException;
import Mattiazerbini.U5_W1_D5.repositories.EdificioRepository;
import Mattiazerbini.U5_W1_D5.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EdificioService {

    private final EdificioRepository edificioRepository;

    @Autowired
    public EdificioService(EdificioRepository edificioRepository){
        this.edificioRepository = edificioRepository;
    }
    public void salvaEdificio(Edificio newEdificio){
        if(edificioRepository.existsById((newEdificio.getId())))
            throw  new ValidationException("Questo edificio " +newEdificio.getNome()+ " è gia registrato");
        this.edificioRepository.save(newEdificio);
        log.info("L'edificio " +newEdificio.getNome()+" è stato salvato!");
    }

    public Edificio findByEdificioId(long id){
        Optional<Edificio> post = edificioRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else{
            throw new NotfoundExcetion("Edificio con l'id " +id+ " non trovato");
        }
    }

}
