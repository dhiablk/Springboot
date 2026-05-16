package com.nadhem.produits.restcontrollers;

import com.nadhem.produits.entities.Fournisseur;
import com.nadhem.produits.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FournisseurRestController {

    @Autowired
    FournisseurService fournisseurService;

    @GetMapping("/fournisseurs")
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.getAllFournisseurs();
    }

    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> getFournisseur(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurService.getFournisseur(id);
        return fournisseur != null ? ResponseEntity.ok(fournisseur) : ResponseEntity.notFound().build();
    }

    @PostMapping("/fournisseurs")
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.saveFournisseur(fournisseur);
    }

    @PutMapping("/fournisseurs")
    public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.updateFournisseur(fournisseur);
    }

    @DeleteMapping("/fournisseurs/{id}")
    public void deleteFournisseur(@PathVariable Long id) {
        fournisseurService.deleteFournisseur(id);
    }
}