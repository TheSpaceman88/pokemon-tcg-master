// package fr.efrei.pokemon_tcg.services;

// import fr.efrei.pokemon_tcg.models.Carte;
// import fr.efrei.pokemon_tcg.repositories.CarteRepository;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;

// @Service
// public class TirageService {

//     private final CarteRepository carteRepository;
//     private final Random random = new Random();

//     public TirageService(CarteRepository carteRepository) {
//         this.carteRepository = carteRepository;
//     }

//     private static final int[] PROBABILITES = {50, 30, 12, 6, 2};

//     private static final String[][] POKEMON_DATA = {
//             {"Pikachu", "Éclair", "Tonnerre"},
//             {"Bulbizarre", "Fouet Lianes", "Tranch'Herbe"},
//             {"Dracaufeu", "Lance-Flammes", "Danse Flamme"},
//             {"Evoli", "Morsure", "Jet de Sable"},
//             {"Mewtwo", "Psyko", "Onde Psy"}
//     };

//     public List<Carte> genererCartesAleatoires() {
//         List<Carte> cartes = new ArrayList<>();

//         for (int i = 0; i < 5; i++) {
//             String[] pokemon = POKEMON_DATA[random.nextInt(POKEMON_DATA.length)];
//             int rarete = tirerRarete();

//             Carte carte = Carte.builder()
//                     .nomPokemon(pokemon[0] + " " + rarete + "★")
//                     .attaque1(pokemon[1])
//                     .attaque2(pokemon[2])
//                     .rarete(rarete)
//                     .build();

//             carteRepository.save(carte);
//             cartes.add(carte);
//         }
//         return cartes;
//     }

//     private int tirerRarete() {
//         int rand = random.nextInt(100);
//         int cumulative = 0;

//         for (int i = 0; i < PROBABILITES.length; i++) {
//             cumulative += PROBABILITES[i];
//             if (rand < cumulative) {
//                 return i + 1;
//             }
//         }
//         return 1;
//     }
// }
