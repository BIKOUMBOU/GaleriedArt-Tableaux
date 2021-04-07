package galerie.entity;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString

@Entity

public class Exposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private LocalDate debut = LocalDate.now();
    private String intitule;
    private Integer duree =  12;

    @ManyToOne
    @NonNull
    Galerie organisateur;

    @ManyToMany
    @ToString.Exclude
    List<Tableau> oeuvres = new LinkedList<>();

    @OneToMany(mappedBy = "lieuDeLaVente)")
    @ToString.Exclude
    private  List<Transaction> ventes = new LinkedList<>();

        public float CA(){
            float r = 0.000f;
            for (Transaction v: ventes)
                r+= ventes.getPrixDeVente();
            return r;
        }


}
