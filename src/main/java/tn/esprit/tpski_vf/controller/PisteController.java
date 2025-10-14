package tn.esprit.tpski_vf.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpski_vf.entity.Piste;
import tn.esprit.tpski_vf.service.PisteService;

import java.util.List;

@RestController
@RequestMapping("/pistes")
public class PisteController {

    private final PisteService pisteService;

    public PisteController(PisteService pisteService) {
        this.pisteService = pisteService;
    }

    // CREATE
    @PostMapping
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Piste updatePiste(@PathVariable Long id, @RequestBody Piste piste) {
        return pisteService.updatePiste(id, piste);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletePiste(@PathVariable Long id) {
        pisteService.deletePiste(id);
    }

    // READ - ALL
    @GetMapping
    public List<Piste> getAllPistes() {
        return pisteService.getAllPistes();
    }

    // READ - ONE
    @GetMapping("/{id}")
    public Piste getPisteById(@PathVariable Long id) {
        return pisteService.getPisteById(id);
    }
}
