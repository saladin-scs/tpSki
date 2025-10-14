package tn.esprit.tpski_vf.service;

import org.springframework.stereotype.Service;
import tn.esprit.tpski_vf.entity.Piste;
import tn.esprit.tpski_vf.repository.PisteRepository;

import java.util.List;

@Service  // Indique que c’est un service Spring
public class PisteService{

    private final PisteRepository pisteRepository;

    // Injection du repository via le constructeur
    public PisteService(PisteRepository pisteRepository) {
        this.pisteRepository = pisteRepository;
    }

    // ✅ Récupérer toutes les pistes
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    // ✅ Ajouter une piste
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    // ✅ Mettre à jour une piste
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste); // save() fait add ou update
    }

    // ✅ Récupérer une piste par ID
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
        // ou lever exception si non trouvé
    }

    // ✅ Supprimer une piste
    public void deletePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }
}
