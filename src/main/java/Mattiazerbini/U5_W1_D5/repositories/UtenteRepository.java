package Mattiazerbini.U5_W1_D5.repositories;

import Mattiazerbini.U5_W1_D5.entitites.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    boolean existsBymail(String mail);

}
