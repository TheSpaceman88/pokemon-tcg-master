package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.services.CarteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cartes")
public class CarteController {

    private final CarteService carteService;

    public CarteController(CarteService carteService) {
        this.carteService = carteService;
    }

    @GetMapping
    public ResponseEntity<List<Carte>> getAll() {
        List<Carte> cartes = carteService.getAllCartes();
        return cartes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cartes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carte> getById(@PathVariable Long id) {
        return carteService.getCarteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carte> createCarte(@Valid @RequestBody Carte carte) {
        Carte savedCarte = carteService.saveCarte(carte);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCarte);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarte(@PathVariable Long id) {
        boolean isSupprimer = carteService.deleteCarte(id);
        return isSupprimer ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
