package com.nadhem.produits.service;

import com.nadhem.produits.entities.Fournisseur;
import com.nadhem.produits.repos.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    FournisseurRepository fournisseurRepository;

    @Override
    public Fournisseur saveFournisseur(Fournisseur f) {
        return fournisseurRepository.save(f);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        return fournisseurRepository.save(f);
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }

    @Override
    public Fournisseur getFournisseur(Long id) {
        Optional<Fournisseur> opt = fournisseurRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }
}