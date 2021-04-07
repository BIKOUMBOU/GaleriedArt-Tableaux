package galerie.entity;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString

@Entity

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    private Personne client;

    @NonNull
    @ManyToOne
    private Tableau oeuvre;

    @NonNull
    private  Float prixDeVente;

    private LocalDate venduCe = LocalDate.now();
}
