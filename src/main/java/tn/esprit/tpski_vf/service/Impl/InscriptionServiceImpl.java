package tn.esprit.tpski_vf.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpski_vf.entity.Inscription;
import tn.esprit.tpski_vf.repository.InscriptionRepository;
import tn.esprit.tpski_vf.service.InscriptionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription updateInscription(Long id, Inscription inscription) {
        Inscription existing = inscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription introuvable avec ID : " + id));

        if (inscription.getNumSemaine() != null) existing.setNumSemaine(inscription.getNumSemaine());
        if (inscription.getSkieur() != null) existing.setSkieur(inscription.getSkieur());
        if (inscription.getCours() != null) existing.setCours(inscription.getCours());

        return inscriptionRepository.save(existing);
    }

    @Override
    public void deleteInscription(Long id) {
        if (!inscriptionRepository.existsById(id)) {
            throw new RuntimeException("Inscription introuvable avec ID : " + id);
        }
        inscriptionRepository.deleteById(id);
    }

    @Override
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription getInscriptionById(Long id) {
        return inscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription introuvable avec ID : " + id));
    }
}
