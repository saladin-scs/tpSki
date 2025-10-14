package tn.esprit.tpski_vf.service;

import tn.esprit.tpski_vf.entity.Moniteur;
import java.util.List;

public interface MoniteurService {

    Moniteur addMoniteur(Moniteur moniteur);

    Moniteur updateMoniteur(Long id, Moniteur moniteur);

    void deleteMoniteur(Long id);

    List<Moniteur> getAllMoniteurs();

    Moniteur getMoniteurById(Long id);
}
