package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.repositories.CardRepository;
import fr.efrei.pokemon_tcg.services.ICardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

	 private final CardRepository repository;

	 public CardServiceImpl(CardRepository repository) {
    	this.repository = repository;
	}

	 @Override
	 public List<Card> findAll() {
	 	return repository.findAll();
	}

	 @Override
	 public Card findById(String uuid) {
	 	return repository.findById(uuid).orElse(null);
  }

	 @Override
	 public void save(Card type) {
	 	repository.save(type);
	 }
}
