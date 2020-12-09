package com.ecommerce.microcommerce.controller;


import com.ecommerce.microcommerce.dao.VoitureDao;
import com.ecommerce.microcommerce.model.Voiture;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Gestion des véhicules")
@RestController
public class VoitureController {

    @Autowired
    private VoitureDao voitureDao;

    //Voitures
    @GetMapping(value = "Voitures")
    public List<Voiture> listVoitures(){
        return voitureDao.findAll();
    }

    //Voitures/{id}
    @ApiOperation(value = "Récupère un véhicule selon son Id")
    @GetMapping(value = "Voitures/{id}")
    public Voiture afficherUneVoiture(@PathVariable int id){
        return voitureDao.findById(id);
    }

    @PostMapping(value = "/Voitures")
    public void ajouterVoiture(@RequestBody Voiture voiture){
        voitureDao.save(voiture);
    }

    @PutMapping(value = "/Voitures/{id}")
    public Voiture modifierUnElement(@RequestBody Voiture voiture, @PathVariable int id) {
        return voitureDao.update(id, voiture);
    }

    @DeleteMapping(value = "/Voitures/{id}")
    public Voiture supprimerUnElement(@PathVariable int id) {
        return voitureDao.delete(id);
    }
}
