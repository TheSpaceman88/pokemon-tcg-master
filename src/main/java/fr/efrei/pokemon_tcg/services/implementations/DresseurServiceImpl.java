package fr.efrei.pokemon_tcg.services.implementations;
import fr.efrei.pokemon_tcg.dto.TirageCarte;
import fr.efrei.pokemon_tcg.dto.CapturePokemon;
import fr.efrei.pokemon_tcg.dto.DresseurDTO;//1
import fr.efrei.pokemon_tcg.models.Dresseur;
import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.models.Carte; //1
import fr.efrei.pokemon_tcg.repositories.DresseurRepository; //1
import fr.efrei.pokemon_tcg.services.IDresseurService;
import fr.efrei.pokemon_tcg.services.IPokemonService;
import fr.efrei.pokemon_tcg.services.ICarteService; //1
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DresseurServiceImpl implements IDresseurService {

	private final DresseurRepository repository;
	private final IPokemonService pokemonService;
	private final ICarteService carteService;
	public DresseurServiceImpl(DresseurRepository repository, PokemonServiceImpl pokemonService, ICarteService carteService) {
		this.repository = repository;
		this.pokemonService = pokemonService;
		this.carteService = carteService;
	}

	@Override
	public List<Dresseur> findAll() {
		return repository.findAllByDeletedAtNull();
	}

	@Override
	public Dresseur findById(String uuid) {
		return repository.findById(uuid).orElse(null);
	}

	public void capturerPokemon(String uuid, CapturePokemon capturePokemon) {
		Dresseur dresseur = findById(uuid);
		Pokemon pokemon = pokemonService.findById(capturePokemon.getUuid());
		dresseur.getPokemonList().add(pokemon);
		repository.save(dresseur);
	}
	public void tirageCarte(String uuid, TirageCarte tirageCarte) {
		Dresseur dresseur = findById(uuid);
		Carte carte = carteService.findById(tirageCarte.getUuid());
		dresseur.getCarteList().add(carte);
		repository.save(dresseur);
	}

	@Override
	public void create(DresseurDTO dresseurDTO) {
		Dresseur dresseur = new Dresseur();
		dresseur.setNom(dresseurDTO.getNom());
		dresseur.setPrenom(dresseurDTO.getPrenom());
		dresseur.setDeletedAt(null);
		repository.save(dresseur);
	}

	@Override
	public boolean update(String uuid, DresseurDTO dresseurDTO) {
		return false;
	}

	@Override
	public boolean delete(String uuid) {
		Dresseur dresseur = findById(uuid);
		dresseur.setDeletedAt(LocalDateTime.now());
		repository.save(dresseur);
		return true;
	}


}
