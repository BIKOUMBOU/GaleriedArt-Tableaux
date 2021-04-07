package galerie.entity;

import java.util.*;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString

public class Tableau {

    @Entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String titre;
    private String dimensions;
    private String support;

    @OneToMany(mappedBy = "oeuvre")
    @ToString.Exclude
    private Transaction vendu;

    @ManyToOne
    Artiste auteur;

    @ToString.Exclude
    @ManyToMany(mappedBy = "oeuvre")
    private List<Exposition> accrochages = new LinkedList<>();


}
