package com.nadhem.produits.restcontrollers;

import com.nadhem.produits.entities.Categorie;
import com.nadhem.produits.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategorieRestController {

    @Autowired
    CategorieService categorieService;

    @GetMapping("/categories")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Categorie> getCategorie(@PathVariable Long id) {
        Categorie categorie = categorieService.getCategorie(id);
        return categorie != null ? ResponseEntity.ok(categorie) : ResponseEntity.notFound().build();
    }

    @PostMapping("/categories")
    public Categorie createCategorie(@RequestBody Categorie categorie) {
        return categorieService.saveCategorie(categorie);
    }

    @PutMapping("/categories")
    public Categorie updateCategorie(@RequestBody Categorie categorie) {
        return categorieService.updateCategorie(categorie);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
    }
}