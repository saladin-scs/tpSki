package tn.esprit.tpski_vf.service;

import tn.esprit.tpski_vf.entity.Skieur;
import java.util.List;

public interface SkieurService {

    Skieur addSkieur(Skieur skieur);

    Skieur updateSkieur(Long id, Skieur skieur);

    void deleteSkieur(Long id);

    List<Skieur> getAllSkieurs();

    Skieur getSkieurById(Long id);
}
