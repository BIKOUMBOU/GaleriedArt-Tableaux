package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    // TODO : Mettre en oeuvre la relation oneToMany vers


    OneToMany(mappedBy ="organisateur")
    List<Exposition> evenements = new LinkedList<>();

        public float CAannuel(int annee) {
         float r = 0.000f;
             for (Exposition evenement : evenements)
                 if (evenement.getDebut().getYear() == annee)
                     r += evenement.CA();
                  return  r;

    }

}
