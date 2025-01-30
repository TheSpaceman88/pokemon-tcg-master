package fr.efrei.pokemon_tcg.controllers;

import fr.efrei.pokemon_tcg.constants.TypeCard;
//import fr.efrei.pokemon_tcg.dto.CreateCard;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.services.ICardService;
import fr.efrei.pokemon_tcg.services.implementations.CardServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Card")
public class CardController {
	private final ICardService cardService;
	public CardController(CardServiceImpl CardService) {
		this.cardService = cardService;
	}
}