package com.nadhem.produits.restcontrollers;

import com.nadhem.produits.entities.Rayon;
import com.nadhem.produits.service.RayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RayonRestController {

    @Autowired
    RayonService rayonService;

    @GetMapping("/rayons")
    public List<Rayon> getAllRayons() {
        return rayonService.getAllRayons();
    }

    @GetMapping("/rayons/{id}")
    public ResponseEntity<Rayon> getRayon(@PathVariable Long id) {
        Rayon rayon = rayonService.getRayon(id);
        return rayon != null ? ResponseEntity.ok(rayon) : ResponseEntity.notFound().build();
    }

    @PostMapping("/rayons")
    public Rayon createRayon(@RequestBody Rayon rayon) {
        return rayonService.saveRayon(rayon);
    }

    @PutMapping("/rayons")
    public Rayon updateRayon(@RequestBody Rayon rayon) {
        return rayonService.updateRayon(rayon);
    }

    @DeleteMapping("/rayons/{id}")
    public void deleteRayon(@PathVariable Long id) {
        rayonService.deleteRayon(id);
    }
}