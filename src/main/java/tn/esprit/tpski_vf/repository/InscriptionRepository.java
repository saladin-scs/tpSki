package tn.esprit.tpski_vf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpski_vf.entity.Inscription;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
