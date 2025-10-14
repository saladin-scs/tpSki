package tn.esprit.tpski_vf.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpski_vf.entity.Abonnement;
import tn.esprit.tpski_vf.repository.AbonnementRepository;
import tn.esprit.tpski_vf.service.AbonnementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbonnementServiceImpl implements AbonnementService {

    private final AbonnementRepository abonnementRepository;

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Long id, Abonnement abonnement) {
        Abonnement existing = abonnementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abonnement introuvable avec ID : " + id));

        if (abonnement.getTypeAbonnement() != null) existing.setTypeAbonnement(abonnement.getTypeAbonnement());
        if (abonnement.getDateDebut() != null) existing.setDateDebut(abonnement.getDateDebut());
        if (abonnement.getDateFin() != null) existing.setDateFin(abonnement.getDateFin());
        if (abonnement.getPrix() != null) existing.setPrix(abonnement.getPrix());

        return abonnementRepository.save(existing);
    }

    @Override
    public void deleteAbonnement(Long id) {
        if (!abonnementRepository.existsById(id)) {
            throw new RuntimeException("Abonnement introuvable avec ID : " + id);
        }
        abonnementRepository.deleteById(id);
    }

    @Override
    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement getAbonnementById(Long id) {
        return abonnementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abonnement introuvable avec ID : " + id));
    }
}
