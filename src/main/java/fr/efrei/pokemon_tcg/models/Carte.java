package fr.efrei.pokemon_tcg.models;

import fr.efrei.pokemon_tcg.constants.TypeCarte;
import jakarta.persistence.*;

@Entity
public class Carte {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	private String nom;

    private String attaque1;
    
    private String attaque2;

	// private Integer niveau;

	@Enumerated(EnumType.STRING)
	private TypeCarte type;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


    public String getAttaque1() {
		return attaque1;
	}

	public void setAttaque1(String attaque1) {
		this.attaque1 = attaque1;
	}

    public String getAttaque2() {
		return attaque2;
	}

	public void setAttaque2(String attaque2) {
		this.attaque2 = attaque2;
	}

	// public Integer getNiveau() {
	// 	return niveau;
	// }

	// public void setNiveau(Integer niveau) {
	// 	this.niveau = niveau;
	// }

	public TypeCarte getType() {
		return type;
	}

	public void setType(TypeCarte type) {
		this.type = type;
	}

	public String getUuid() {
		return uuid;
	}
}
