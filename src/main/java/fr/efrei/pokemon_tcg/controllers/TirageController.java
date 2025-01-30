package fr.efrei.pokemon_tcg.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.models.Carte;
import fr.efrei.pokemon_tcg.services.TirageService;

@RestController
@RequestMapping("/tirage")
public class TirageController {

    private final TirageService tirageService;

    public TirageController(TirageService tirageService) {
        this.tirageService = tirageService;
    }

    @PostMapping
    public List<Carte> tirerCartes() {
        return tirageService.genererCartesAleatoires();
    }
}