package tn.esprit.tpski_vf.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpski_vf.entity.Skieur;
import tn.esprit.tpski_vf.repository.SkieurRepository;
import tn.esprit.tpski_vf.service.SkieurService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkieurServiceImpl implements SkieurService {

    private final SkieurRepository skieurRepository;

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Long id, Skieur skieur) {
        Skieur existing = skieurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skieur introuvable avec ID : " + id));

        if (skieur.getNomS() != null) existing.setNomS(skieur.getNomS());
        if (skieur.getPrenomS() != null) existing.setPrenomS(skieur.getPrenomS());
        if (skieur.getDateNaissance() != null) existing.setDateNaissance(skieur.getDateNaissance());
        if (skieur.getVille() != null) existing.setVille(skieur.getVille());
        if (skieur.getAbonnement() != null) existing.setAbonnement(skieur.getAbonnement());
        if (skieur.getPistes() != null && !skieur.getPistes().isEmpty()) existing.setPistes(skieur.getPistes());

        return skieurRepository.save(existing);
    }

    @Override
    public void deleteSkieur(Long id) {
        if (!skieurRepository.existsById(id)) {
            throw new RuntimeException("Skieur introuvable avec ID : " + id);
        }
        skieurRepository.deleteById(id);
    }

    @Override
    public List<Skieur> getAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur getSkieurById(Long id) {
        return skieurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skieur introuvable avec ID : " + id));
    }
}
