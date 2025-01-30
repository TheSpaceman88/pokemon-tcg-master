package fr.efrei.pokemon_tcg.repositories;

import fr.efrei.pokemon_tcg.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
}
