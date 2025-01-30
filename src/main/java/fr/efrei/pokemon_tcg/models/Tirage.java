package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tirages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "builder")
public class Tirage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID joueurId;

    @Column(nullable = false)
    private LocalDate dateTirage;

    @ManyToMany
    @JoinTable(
        name = "tirage_cartes",
        joinColumns = @JoinColumn(name = "tirage_id"),
        inverseJoinColumns = @JoinColumn(name = "carte_id")
    )
    private List<Carte> cartes;
}