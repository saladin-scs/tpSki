package tn.esprit.tpski_vf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpski_vf.entity.Moniteur;

@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur, Long> {
    // JpaRepository fournit déjà : findAll(), save(), findById(), deleteById()
}
