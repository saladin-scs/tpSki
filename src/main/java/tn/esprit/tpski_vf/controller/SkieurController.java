package tn.esprit.tpski_vf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // POST /skieurs → Ajouter un skieur
    @PostMapping
    public ResponseEntity<Skieur> addSkieur(@RequestBody Skieur skieur) {
        try {
            Skieur saved = skieurService.addSkieur(skieur);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // GET /skieurs → Liste de tous les skieurs
    @GetMapping
    public ResponseEntity<List<Skieur>> getAllSkieurs() {
        return ResponseEntity.ok(skieurService.retrieveAllSkieurs());
    }
}
