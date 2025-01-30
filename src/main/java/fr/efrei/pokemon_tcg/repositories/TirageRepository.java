package fr.efrei.pokemon_tcg.repositories;

import fr.efrei.pokemon_tcg.models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface TirageRepository extends JpaRepository<Tirage, UUID> {
    List<Tirage> findByJoueurIdAndDateTirage(UUID joueurId, LocalDate dateTirage);
    List<Tirage> findByJoueurId(UUID joueurId);
}