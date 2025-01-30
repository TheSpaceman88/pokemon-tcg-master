package fr.efrei.pokemon_tcg.services;

import java.time.LocalDate;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.repositories.CarteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarteService {

    private final CarteRepository carteRepository;

    public CarteService(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }

    public Carte getCarteById(Long id) {
        return carteRepository.findById(id).orElse(null);
    }

    public Carte saveCarte(Carte carte) {
        carte.setDateCreation(LocalDate.now());
        return carteRepository.save(carte);
    }

    public void deleteCarte(Long id) {
        if (carteRepository.existsById(id)) {
            carteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Carte avec l'ID " + id + " non trouvée.");
        }
    }
}