package fr.efrei.pokemon_tcg.services.implementations;

import fr.efrei.pokemon_tcg.models.Tirage;
import fr.efrei.pokemon_tcg.repositories.TirageRepository;
import fr.efrei.pokemon_tcg.services.ITirageService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TirageServiceImpl implements ITirageService {

    private final TirageRepository repository;

    public TirageServiceImpl(TirageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tirage> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Tirage> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public Optional<Tirage> tirerCartes(UUID joueurId) {
        LocalDate aujourdHui = LocalDate.now();
        List<Tirage> tiragesDuJour = repository.findByJoueurIdAndDateTirage(joueurId, aujourdHui);
        if (tiragesDuJour.size() >= 5) {
            return Optional.empty();
        }

        Tirage tirage = Tirage.builder()
                .joueurId(joueurId)
                .dateTirage(aujourdHui)
                .build();
        
        return Optional.of(repository.save(tirage));
    }

    @Override
    public boolean update(UUID uuid, Tirage tirage) {
        if (repository.existsById(uuid)) {
            Tirage existingTirage = repository.findById(uuid).orElseThrow();
            existingTirage.setJoueurId(tirage.getJoueurId());
            existingTirage.setDateTirage(tirage.getDateTirage());
            existingTirage.setCartes(tirage.getCartes());
            repository.save(existingTirage);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(UUID uuid) {
        if (repository.existsById(uuid)) {
            repository.deleteById(uuid);
            return true;
        }
        return false;
    }
}
