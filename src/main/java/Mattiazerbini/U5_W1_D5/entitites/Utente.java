package Mattiazerbini.U5_W1_D5.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@Getter
@Setter

public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String mail;

    public Utente(String username, String nome, String cognome, String mail) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
    }

    public Utente() {
    }
}
