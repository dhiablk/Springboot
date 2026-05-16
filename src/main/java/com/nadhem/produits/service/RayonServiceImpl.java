package com.nadhem.produits.service;

import com.nadhem.produits.entities.Rayon;
import com.nadhem.produits.repos.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RayonServiceImpl implements RayonService {

    @Autowired
    RayonRepository rayonRepository;

    @Override
    public Rayon saveRayon(Rayon r) {
        return rayonRepository.save(r);
    }

    @Override
    public Rayon updateRayon(Rayon r) {
        return rayonRepository.save(r);
    }

    @Override
    public void deleteRayon(Long id) {
        rayonRepository.deleteById(id);
    }

    @Override
    public Rayon getRayon(Long id) {
        Optional<Rayon> opt = rayonRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public List<Rayon> getAllRayons() {
        return rayonRepository.findAll();
    }
}