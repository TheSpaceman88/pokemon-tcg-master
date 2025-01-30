package fr.efrei.pokemon_tcg.services;

import java.time.LocalDate;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.repositories.CarteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ICarteService {

	List<Carte> findAll(TypeCarte type);

	Carte findById(String uuid);

	void create(CreateCarte carte);

	boolean update(String uuid, Carte carte);

	boolean delete(String uuid);
}
