package tn.esprit.tpski_vf.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tpski_vf.entity.Moniteur;
import tn.esprit.tpski_vf.repository.MoniteurRepository;

import java.util.List;

@Service
@Transactional
public class MoniteurService {

    private final MoniteurRepository moniteurRepository;

    public MoniteurService(MoniteurRepository moniteurRepository) {
        this.moniteurRepository = moniteurRepository;
    }

    // Récupérer tous les moniteurs
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    // Récupérer un moniteur par ID
    public Moniteur retrieveMoniteur(Long id) {
        return moniteurRepository.findById(id).orElse(null);
    }

    // Ajouter un moniteur
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    // Mettre à jour un moniteur
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    // Supprimer un moniteur
    public void deleteMoniteur(Long id) {
        moniteurRepository.deleteById(id);
    }
}
