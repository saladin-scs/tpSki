package tn.esprit.tpski_vf.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpski_vf.entity.Inscription;
import tn.esprit.tpski_vf.service.InscriptionService;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    // CREATE
    @PostMapping
    public Inscription addInscription(@RequestBody Inscription inscription) {
        return inscriptionService.addInscription(inscription);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Inscription updateInscription(@PathVariable Long id, @RequestBody Inscription inscription) {
        return inscriptionService.updateInscription(id, inscription);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
    }

    // READ - ALL
    @GetMapping
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    // READ - ONE
    @GetMapping("/{id}")
    public Inscription getInscriptionById(@PathVariable Long id) {
        return inscriptionService.getInscriptionById(id);
    }
}
