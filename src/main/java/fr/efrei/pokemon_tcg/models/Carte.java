package fr.efrei.pokemon_tcg.models;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cartes") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName= "builder")

public class Carte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomPokemon; // pikachu

    @Column(nullable = false)
    private LocalDate dateCreation;

    @Column(nullable = false)
    private String attaque1;

    @Column(nullable = false)
    private String attaque2;

    @Column
    private Integer userID; // 0

    @Column
    private Integer rarete = 1;  // 1 //
    
}
