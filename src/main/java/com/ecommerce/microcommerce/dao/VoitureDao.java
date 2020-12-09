package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Voiture;

import java.util.List;

public interface VoitureDao {

    public List<Voiture> findAll();

    public Voiture findById(int id);

    public Voiture save(Voiture voiture);

    Voiture update(int id, Voiture voiture);

    Voiture delete(int id);
}
