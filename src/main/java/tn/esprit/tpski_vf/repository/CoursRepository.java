package tn.esprit.tpski_vf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpski_vf.entity.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
