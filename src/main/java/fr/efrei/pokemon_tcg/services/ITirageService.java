package fr.efrei.pokemon_tcg.services;

import fr.efrei.pokemon_tcg.models.Tirage;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITirageService {

    List<Tirage> findAll();

    Optional<Tirage> findById(UUID uuid);

    Optional<Tirage> tirerCartes(UUID joueurId);

    boolean update(UUID uuid, Tirage tirage);

    boolean delete(UUID uuid);

    List<Tirage> findByJoueurId(UUID joueurId);

    List<Tirage> findByJoueurIdAndDateTirage(UUID joueurId, LocalDate dateTirage);
}