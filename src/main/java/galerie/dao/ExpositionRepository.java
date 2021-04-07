package galerie.dao;

import galerie.dto.CaDeExposition;
import java.util.List;
import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query;
import org.springframework.data.jpa.repository.query.DefaultJpaQueryMethodFactory;

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {

    // Version JPQL : exprimée en termes du modèle conceptuel de donnéez
    @Query("SELECT SUM(t.prixVente) FROM Transaction t WHERE t.lieuDeVente.id = :id")
    // Version SQL natif: exprimée en terme du modèle logique de données
    //@Query(value = "SELECT SUM(prix_vente) FROM transaction WHERE lieu_de_vente_id = :id", nativeQuery = true)
    Float chiffreAffairePourId(Integer id);

    // Si on cherche sur l'intitulé de l'exposition, JPQL va générer une requête de jointure
    @Query("SELECT SUM(t.prixVente) FROM Transaction t WHERE t.lieuDeVente.intitule = :intitule")
    Float chiffreAffairePourIntitule(String intitule);

    // Une requête qui renvoie une liste de DTO (Data Transfer Object)
    @Query("SELECT t.lieuDeVente.intitule as intitule, SUM(t.prixVente) as CA FROM Transaction t GROUP BY intitule")
    List<CaDeExposition> listeCA();


}
