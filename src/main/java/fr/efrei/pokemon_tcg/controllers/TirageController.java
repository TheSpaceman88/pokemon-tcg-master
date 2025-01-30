package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.dto.CreateTirage;
import fr.efrei.pokemon_tcg.models.Tirage;
import fr.efrei.pokemon_tcg.services.ITirageService;
import fr.efrei.pokemon_tcg.services.implementations.TirageServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tirages")
public class TirageController {

    private final ITirageService tirageService;

    public TirageController(TirageServiceImpl tirageService) {
        this.tirageService = tirageService;
    }

    @GetMapping
    public ResponseEntity<List<Tirage>> getAll() {
        List<Tirage> tirages = tirageService.findAll();
        return ResponseEntity.ok(tirages);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Tirage> getById(@PathVariable UUID uuid) {
        Optional<Tirage> tirage = tirageService.findById(uuid);
        return tirage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createTirage(@Valid @RequestBody CreateTirage tirage) {
        tirageService.create(tirage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> updateTirage(@PathVariable UUID uuid, @RequestBody Tirage tirage) {
        boolean isModifier = tirageService.update(uuid, tirage);
        return isModifier ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deleteTirage(@PathVariable UUID uuid) {
        boolean isSupprimer = tirageService.delete(uuid);
        return isSupprimer ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
