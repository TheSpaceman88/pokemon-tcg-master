package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.constants.TypeCarte;
import fr.efrei.pokemon_tcg.dto.CreateCarte;
import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.models.Dresseur;
import fr.efrei.pokemon_tcg.repositories.CarteRepository;
import fr.efrei.pokemon_tcg.services.ICarteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteServiceImpl implements ICarteService {

	private final CarteRepository repository;

	public CarteServiceImpl(CarteRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Carte> findAll() {
		return repository.findAll();
	}

	@Override
	public void create(CreateCarte carte) {
		Carte carteACreer = new Carte();
		carteACreer.setType(carte.getType());
		carteACreer.setNom(carte.getNom());
		carteACreer.setAttaque1(carte.getAttaque1());
		carteACreer.setAttaque2(carte.getAttaque2());
		repository.save(carteACreer);
	}

	@Override
	public Carte findById(String uuid) {
		// renvoie soit un carte soit null
		
		return repository.findById(uuid).orElse(null);
	}

	@Override
	public boolean update(String uuid, Carte carte) {
		Carte carteAModifier = findById(uuid);
		if(carteAModifier == null) {
			return false;
		}
		carteAModifier.setNom(carte.getNom());
		carteAModifier.setNiveau(carte.getNiveau());
		carteAModifier.setType(carte.getType());
		repository.save(carteAModifier);
		return true;
	}

	// @Override
	// public boolean delete(String uuid) {
	// 	Carte carteAModifier = findById(uuid);
	// 	if(carteAModifier == null) {
	// 		return false;
	// 	}
	// 	repository.deleteById(uuid);
	// 	return true;
	// }
}
