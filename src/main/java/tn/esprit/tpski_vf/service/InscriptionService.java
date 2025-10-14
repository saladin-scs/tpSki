package tn.esprit.tpski_vf.service;

import tn.esprit.tpski_vf.entity.Inscription;
import java.util.List;

public interface InscriptionService {

    Inscription addInscription(Inscription inscription);

    Inscription updateInscription(Long id, Inscription inscription);

    void deleteInscription(Long id);

    List<Inscription> getAllInscriptions();

    Inscription getInscriptionById(Long id);
}
