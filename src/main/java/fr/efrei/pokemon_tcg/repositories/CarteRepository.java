package fr.efrei.pokemon_tcg.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.pokemon_tcg.models.Carte;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long> {
    //List<Carte> findAllByDeletedAtNull();
}
