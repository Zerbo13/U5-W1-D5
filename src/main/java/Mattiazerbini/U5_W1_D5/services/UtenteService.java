package Mattiazerbini.U5_W1_D5.services;

import Mattiazerbini.U5_W1_D5.exceptions.ValidationException;
import Mattiazerbini.U5_W1_D5.entitites.Utente;
import Mattiazerbini.U5_W1_D5.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Slf4j
@Service
public class UtenteService {
    private final  UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository){
        this.utenteRepository = utenteRepository;
    }

    public void salvaUtente(Utente newUtente){
        if(utenteRepository.existsByEmail(newUtente.getMail()))
            throw  new ValidationException("Questa mail" +newUtente.getMail()+ "è gia registrata");
        this.utenteRepository.save(newUtente);
        log.info("L'utente " +newUtente.getNome()+ newUtente.getCognome()+" è stato salvato!");
    }


}
