package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	private String Type;
}
// 	@ManyToOne
// 	@JoinColumn(name = "dresseur_uuid")
// 	private Dresseur dresseur;

// 	public String getUuid() {
// 		return uuid;
// 	}

// 	public void setUuid(String uuid) {
// 		this.uuid = uuid;
// 	}

// 	public String getNom() {
// 		return nom;
// 	}

// 	public void setNom(String nom) {
// 		this.nom = nom;
// 	}

// 	public Dresseur getDresseur() {
// 		return dresseur;
// 	}

// 	public void setDresseur(Dresseur dresseur) {
// 		this.dresseur = dresseur;
// 	}
// }
