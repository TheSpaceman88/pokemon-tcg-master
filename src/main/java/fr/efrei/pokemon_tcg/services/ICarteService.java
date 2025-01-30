package fr.efrei.pokemon_tcg.services;

import java.time.LocalDate;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.repositories.CarteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ICarteService {

    private final CarteRepository carteRepository;

    public ICarteService(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }
    
    public List<Carte> findAll() {
        return carteRepository.findAll();
    }

//     public Carte getCarteById(Long id) {
//         return carteRepository.findById(id).orElse(null);
//     }

//     public Carte saveCarte(Carte carte) {
//         carte.setDateCreation(LocalDate.now());
//         return carteRepository.save(carte);
//     }

//     public void deleteCarte(Long id) {
//         if (carteRepository.existsById(id)) {
//             carteRepository.deleteById(id);
//         } else {
//             throw new IllegalArgumentException("Carte avec l'ID " + id + " non trouvée.");
//         }
//     }
//     public boolean deleteCarte(String id) {
//         try {
//             Long carteId = Long.parseLong(id); 
//             if (carteRepository.existsById(id)) {
//                 carteRepository.deleteById(id);
//                 return true;
//             }
//         } catch (NumberFormatException e) {
//             return false; 
//         return false;
//     }
    
// }
    
}