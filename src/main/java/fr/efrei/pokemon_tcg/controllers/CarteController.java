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
    public ResponseEntity<List<Carte>> getAll(@RequestParam(required = false) String type) {
        List<Carte> cartes = carteService.findAll(type);
        return cartes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cartes);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Carte> getById(@PathVariable String uuid) {
        Carte carte = carteService.findById(uuid);
        if (carte == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carte, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Carte> createCarte(@Valid @RequestBody Carte carte) {
        Carte savedCarte = carteService.saveCarte(carte);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCarte);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deleteCarte(@PathVariable String uuid) {
        boolean isSupprimer = carteService.delete(uuid);
        if (!isSupprimer) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
