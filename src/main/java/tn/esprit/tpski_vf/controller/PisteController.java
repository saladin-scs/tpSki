package tn.esprit.tpski_vf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpski_vf.entity.Piste;
import tn.esprit.tpski_vf.service.PisteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pistes")
public class PisteController {

    private final PisteService pisteService;

    public PisteController(PisteService pisteService) {
        this.pisteService = pisteService;
    }

    // GET /pistes → toutes les pistes
    @GetMapping
    public List<Piste> getAll() {
        return pisteService.retrieveAllPistes();
    }

    // GET /pistes/{id} → récupérer une piste par ID
    @GetMapping("/{id}")
    public ResponseEntity<Piste> getOne(@PathVariable Long id) {
        Piste piste = pisteService.retrievePiste(id);
        if (piste != null) {
            return ResponseEntity.ok(piste);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // POST /pistes → ajouter une piste
    @PostMapping
    public ResponseEntity<Piste> create(@RequestBody Piste piste) {
        try {
            Piste saved = pisteService.addPiste(piste);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // PUT /pistes → mettre à jour une piste
    @PutMapping
    public ResponseEntity<Piste> update(@RequestBody Piste piste) {
        try {
            Piste updated = pisteService.updatePiste(piste);
            if (updated != null) {
                return ResponseEntity.ok(updated);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // DELETE /pistes/{id} → supprimer une piste
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            pisteService.deletePiste(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
