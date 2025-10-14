package tn.esprit.tpski_vf.service;

import tn.esprit.tpski_vf.entity.Piste;
import java.util.List;

public interface PisteService {

    Piste addPiste(Piste piste);

    Piste updatePiste(Long id, Piste piste);

    void deletePiste(Long id);

    List<Piste> getAllPistes();

    Piste getPisteById(Long id);
}
