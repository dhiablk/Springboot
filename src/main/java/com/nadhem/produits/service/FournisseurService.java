package com.nadhem.produits.service;

import com.nadhem.produits.entities.Fournisseur;
import java.util.List;

public interface FournisseurService {
    Fournisseur saveFournisseur(Fournisseur f);
    Fournisseur updateFournisseur(Fournisseur f);
    void deleteFournisseur(Long id);
    Fournisseur getFournisseur(Long id);
    List<Fournisseur> getAllFournisseurs();
}