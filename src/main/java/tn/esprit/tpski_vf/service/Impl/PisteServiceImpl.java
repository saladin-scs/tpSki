package tn.esprit.tpski_vf.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpski_vf.entity.Piste;
import tn.esprit.tpski_vf.repository.PisteRepository;
import tn.esprit.tpski_vf.service.PisteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PisteServiceImpl implements PisteService {

    private final PisteRepository pisteRepository;

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Long id, Piste piste) {
        Piste existing = pisteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Piste introuvable avec ID : " + id));

        if (piste.getNomPiste() != null) existing.setNomPiste(piste.getNomPiste());
        if (piste.getCouleur() != null) existing.setCouleur(piste.getCouleur());
        if (piste.getLongueur() != null) existing.setLongueur(piste.getLongueur());
        if (piste.getPente() != null) existing.setPente(piste.getPente());
        if (piste.getSkieurs() != null && !piste.getSkieurs().isEmpty()) existing.setSkieurs(piste.getSkieurs());

        return pisteRepository.save(existing);
    }

    @Override
    public void deletePiste(Long id) {
        if (!pisteRepository.existsById(id)) {
            throw new RuntimeException("Piste introuvable avec ID : " + id);
        }
        pisteRepository.deleteById(id);
    }

    @Override
    public List<Piste> getAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste getPisteById(Long id) {
        return pisteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Piste introuvable avec ID : " + id));
    }
}
