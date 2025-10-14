package tn.esprit.tpski_vf.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpski_vf.entity.Moniteur;
import tn.esprit.tpski_vf.repository.MoniteurRepository;
import tn.esprit.tpski_vf.service.MoniteurService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoniteurServiceImpl implements MoniteurService {

    private final MoniteurRepository moniteurRepository;

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Long id, Moniteur moniteur) {
        Moniteur existing = moniteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moniteur introuvable avec ID : " + id));

        if (moniteur.getNomM() != null) existing.setNomM(moniteur.getNomM());
        if (moniteur.getPrenomM() != null) existing.setPrenomM(moniteur.getPrenomM());
        if (moniteur.getDateRecru() != null) existing.setDateRecru(moniteur.getDateRecru());
        if (moniteur.getCours() != null && !moniteur.getCours().isEmpty()) existing.setCours(moniteur.getCours());

        return moniteurRepository.save(existing);
    }

    @Override
    public void deleteMoniteur(Long id) {
        if (!moniteurRepository.existsById(id)) {
            throw new RuntimeException("Moniteur introuvable avec ID : " + id);
        }
        moniteurRepository.deleteById(id);
    }

    @Override
    public List<Moniteur> getAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur getMoniteurById(Long id) {
        return moniteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moniteur introuvable avec ID : " + id));
    }
}
