package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.data.repository.JpaRepository;
import  galerie.entity.Tableau;

public interface TableauRepository extends JpaRepository<Tableau, Integer> {
}
