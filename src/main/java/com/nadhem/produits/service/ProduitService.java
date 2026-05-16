package com.nadhem.produits.service;

import com.nadhem.produits.entities.Produit;
import java.util.List;

public interface ProduitService {
    Produit saveProduit(Produit p);
    Produit updateProduit(Produit p);
    void deleteProduit(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();
}
