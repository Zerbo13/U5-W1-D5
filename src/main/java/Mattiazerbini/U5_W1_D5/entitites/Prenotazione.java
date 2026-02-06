package Mattiazerbini.U5_W1_D5.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate giorno;

    @ManyToOne
    @JoinColumn(name = "id_postazione")
    private Postazione id_postazione;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente id_utente;

    public Prenotazione(LocalDate giorno) {
        this.giorno = giorno;
    }

    public Prenotazione() {
    }
}
