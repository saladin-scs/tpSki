package tn.esprit.tpski_vf.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpski_vf.entity.Skieur;
import tn.esprit.tpski_vf.service.SkieurService;

import java.util.List;

@RestController
@RequestMapping("/skieurs")
public class SkieurController {

    private final SkieurService skieurService;

    public SkieurController(SkieurService skieurService) {
        this.skieurService = skieurService;
    }

    // CREATE
    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return skieurService.addSkieur(skieur);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Skieur updateSkieur(@PathVariable Long id, @RequestBody Skieur skieur) {
        return skieurService.updateSkieur(id, skieur);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteSkieur(@PathVariable Long id) {
        skieurService.deleteSkieur(id);
    }

    // READ - ALL
    @GetMapping
    public List<Skieur> getAllSkieurs() {
        return skieurService.getAllSkieurs();
    }

    // READ - ONE
    @GetMapping("/{id}")
    public Skieur getSkieurById(@PathVariable Long id) {
        return skieurService.getSkieurById(id);
    }
}
