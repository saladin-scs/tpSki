package tn.esprit.tpski_vf.service;

import org.springframework.stereotype.Service;
import tn.esprit.tpski_vf.entity.Cours;
import tn.esprit.tpski_vf.repository.CoursRepository;

import java.util.List;

@Service
public class CoursService {

    private final CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    // Récupérer tous les cours
    public List<Cours> retrieveAllCours() {
        return coursRepository.findAll();
    }

    // Ajouter un cours
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    // Mettre à jour un cours
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    // Récupérer un cours par ID
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }

    // Supprimer un cours
    public void deleteCours(Long numCours) {
        coursRepository.deleteById(numCours);
    }
}
