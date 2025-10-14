package tn.esprit.tpski_vf.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpski_vf.entity.Moniteur;
import tn.esprit.tpski_vf.service.MoniteurService;

import java.util.List;

@RestController
@RequestMapping("/moniteurs")
public class MoniteurController {

    private final MoniteurService moniteurService;

    public MoniteurController(MoniteurService moniteurService) {
        this.moniteurService = moniteurService;
    }

    // CREATE
    @PostMapping
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Moniteur updateMoniteur(@PathVariable Long id, @RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(id, moniteur);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteMoniteur(@PathVariable Long id) {
        moniteurService.deleteMoniteur(id);
    }

    // READ - ALL
    @GetMapping
    public List<Moniteur> getAllMoniteurs() {
        return moniteurService.getAllMoniteurs();
    }

    // READ - ONE
    @GetMapping("/{id}")
    public Moniteur getMoniteurById(@PathVariable Long id) {
        return moniteurService.getMoniteurById(id);
    }
}
