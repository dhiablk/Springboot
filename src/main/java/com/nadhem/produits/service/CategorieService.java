package com.nadhem.produits.service;

import com.nadhem.produits.entities.Categorie;
import java.util.List;

public interface CategorieService {
    Categorie saveCategorie(Categorie c);
    Categorie updateCategorie(Categorie c);
    void deleteCategorie(Long id);
    Categorie getCategorie(Long id);
    List<Categorie> getAllCategories();
}