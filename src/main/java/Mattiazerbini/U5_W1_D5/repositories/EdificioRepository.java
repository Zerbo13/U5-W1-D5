package Mattiazerbini.U5_W1_D5.repositories;

import Mattiazerbini.U5_W1_D5.entitites.Edificio;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaAnnotations<Edificio, Long> {
}
