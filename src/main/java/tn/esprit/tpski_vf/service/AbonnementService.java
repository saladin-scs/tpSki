package tn.esprit.tpski_vf.service;

import tn.esprit.tpski_vf.entity.Abonnement;
import java.util.List;

public interface AbonnementService {

    Abonnement addAbonnement(Abonnement abonnement);

    Abonnement updateAbonnement(Long id, Abonnement abonnement);

    void deleteAbonnement(Long id);

    List<Abonnement> getAllAbonnements();

    Abonnement getAbonnementById(Long id);
}
