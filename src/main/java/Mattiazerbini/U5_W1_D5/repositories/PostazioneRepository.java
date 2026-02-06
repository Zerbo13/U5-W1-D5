package Mattiazerbini.U5_W1_D5.repositories;

import Mattiazerbini.U5_W1_D5.entitites.Postazione;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneRepository extends JpaAnnotations<Postazione, Long> {
}
