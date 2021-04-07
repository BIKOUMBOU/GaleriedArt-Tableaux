package galerie.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString

@Entity

public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nom;

    @Column(unique = true)
    private String adresse;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private List<Transaction> achats = new LinkedList<>();

        public float budgetAnnu(int annee)
            float r= 0.000f;
        for (Transaction achat: achats)
            if(achat.getVenduCe().getYear() == annee)
                r += achat.getPrixDeVente();
            retutn r;

}
