package com.nadhem.produits.service;

import com.nadhem.produits.entities.Rayon;
import java.util.List;

public interface RayonService {
    Rayon saveRayon(Rayon r);
    Rayon updateRayon(Rayon r);
    void deleteRayon(Long id);
    Rayon getRayon(Long id);
    List<Rayon> getAllRayons();
}