package tn.esprit.tpski_vf.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpski_vf.entity.Cours;
import tn.esprit.tpski_vf.repository.CoursRepository;
import tn.esprit.tpski_vf.service.CoursService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursService {

    private final CoursRepository coursRepository;

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Long id, Cours cours) {
        Cours existing = coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours introuvable avec ID : " + id));

        if (cours.getNiveau() != null) existing.setNiveau(cours.getNiveau());
        if (cours.getTypeCours() != null) existing.setTypeCours(cours.getTypeCours());
        if (cours.getSupport() != null) existing.setSupport(cours.getSupport());
        if (cours.getPrix() != null) existing.setPrix(cours.getPrix());
        if (cours.getCreneau() != null) existing.setCreneau(cours.getCreneau());
        if (cours.getMoniteur() != null) existing.setMoniteur(cours.getMoniteur());

        return coursRepository.save(existing);
    }

    @Override
    public void deleteCours(Long id) {
        if (!coursRepository.existsById(id)) {
            throw new RuntimeException("Cours introuvable avec ID : " + id);
        }
        coursRepository.deleteById(id);
    }

    @Override
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Cours getCoursById(Long id) {
        return coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours introuvable avec ID : " + id));
    }
}
