package fr.efrei.pokemon_tcg.services;

import java.time.LocalDate;
import java.util.Optional;

import fr.efrei.pokemon_tcg.constants.TypeCarte;
import fr.efrei.pokemon_tcg.controllers.CarteController;
import fr.efrei.pokemon_tcg.dto.CreateCarte;
import fr.efrei.pokemon_tcg.models.Carte;
import java.util.List;


public interface ICarteService {

	List<Carte> findAll();

	//Pokemon findById(String uuid);

	void create(CreateCarte carte);

	//boolean update(String uuid, Pokemon pokemon);

	//boolean delete(String uuid);
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
    
//}