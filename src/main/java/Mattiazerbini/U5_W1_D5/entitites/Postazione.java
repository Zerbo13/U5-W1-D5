package Mattiazerbini.U5_W1_D5.entitites;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int codiceUnivoco;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private Tipo tipo_postazione;

    private int numero_occupanti;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    public Postazione(int codiceUnivoco, String descrizione, Tipo tipo_postazione, int numero_occupanti, Edificio edificio) {
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.tipo_postazione = tipo_postazione;
        this.numero_occupanti = numero_occupanti;
        this.edificio = edificio;
    }

    public Postazione() {
    }
}
