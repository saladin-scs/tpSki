package tn.esprit.tpski_vf.service;

import tn.esprit.tpski_vf.entity.Cours;
import java.util.List;

public interface CoursService {

    Cours addCours(Cours cours);

    Cours updateCours(Long id, Cours cours);

    void deleteCours(Long id);

    List<Cours> getAllCours();

    Cours getCoursById(Long id);
}
