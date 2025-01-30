package fr.efrei.pokemon_tcg.dto;

import fr.efrei.pokemon_tcg.constants.TypeCarte;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class CreateCarte {

	@Length(min = 3, max = 20)
	private String nom;

	@Length(min = 3, max = 20)
	private String attaque1;

	@Length(min = 3, max = 20)
	private String attaque2;

	private TypeCarte type;

	public String getNom() {
		return nom;
	}

	public String getAttaque1() {
		return attaque1;
	}
	public String getAttaque2() {
		return attaque2;
	}
	public TypeCarte getType() {
		return type;
	}
}
