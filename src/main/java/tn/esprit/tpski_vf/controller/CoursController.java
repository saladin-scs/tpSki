package tn.esprit.tpski_vf.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpski_vf.entity.Cours;
import tn.esprit.tpski_vf.service.CoursService;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    private final CoursService coursService;

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    // CREATE
    @PostMapping
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Cours updateCours(@PathVariable Long id, @RequestBody Cours cours) {
        return coursService.updateCours(id, cours);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
    }

    // READ - ALL
    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }

    // READ - ONE
    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable Long id) {
        return coursService.getCoursById(id);
    }
}
