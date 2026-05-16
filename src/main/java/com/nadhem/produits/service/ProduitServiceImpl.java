package com.nadhem.produits.service;

import com.nadhem.produits.entities.Produit;
import com.nadhem.produits.repos.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public Produit updateProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        Optional<Produit> opt = produitRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
}
