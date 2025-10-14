package tn.esprit.tpski_vf.service;

import org.springframework.stereotype.Service;
import tn.esprit.tpski_vf.entity.Skieur;
import tn.esprit.tpski_vf.repository.SkieurRepository;

import java.util.List;

@Service
public class SkieurService {

    private final SkieurRepository skieurRepository;

    public SkieurService(SkieurRepository skieurRepository) {
        this.skieurRepository = skieurRepository;
    }

    // Récupérer tous les skieurs
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    // Ajouter un skieur avec son abonnement
    public Skieur addSkieur(Skieur skieur) {
        // grâce à cascade ALL, l'abonnement est automatiquement persistant
        return skieurRepository.save(skieur);
    }

    // Supprimer un skieur (et son abonnement)
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    // Récupérer un skieur par ID
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }
}
