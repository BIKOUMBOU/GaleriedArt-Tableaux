package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Artiste;

public interface ArtisteRepository extends JpaRepository<Artiste, Integer> {
}
