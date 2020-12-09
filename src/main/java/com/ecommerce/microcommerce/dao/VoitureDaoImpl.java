package com.ecommerce.microcommerce.dao;


import com.ecommerce.microcommerce.model.Voiture;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class VoitureDaoImpl implements VoitureDao{

    public static List<Voiture> voitures = new ArrayList<>();

    static {
        voitures.add(new Voiture(1, new String("Polo"), new String("Volkswagen"), new String("Rouge flash")));
        voitures.add(new Voiture(2, new String("Vanquish"), new String("Aston Martin"), new String("Gris")));
        voitures.add(new Voiture(3, new String("Impreza"), new String("Subaru"), new String("Pimpée")));
        voitures.add(new Voiture(4, new String("Gallardo"), new String("Lamborghini"), new String("Carbone")));
        voitures.add(new Voiture(5, new String("Camaro"), new String("Chevrolet"), new String("Jaune")));
    }

    @Override
    public List<Voiture> findAll() {
        return voitures;
    }

    @Override
    public Voiture findById(int id) {

        for (Voiture voiture : voitures) {
            if (voiture.getId()==(id)) {
                return voiture;
            }
        }
        return null;
    }

    @Override
    public Voiture save(Voiture voiture) {

        voitures.add(voiture);
        return voiture;
    }

    @Override
    public Voiture update(int id, Voiture voiture_selectionnée) {
        for (Voiture voiture : voitures) {
            if(voiture.getId() == id){
                int index = voitures.indexOf(voiture);
                voitures.set(index, voiture_selectionnée);
                return voiture;
            }
        }
        return null;    }

    @Override
    public Voiture delete(int id) {
        Voiture voiture_supprimée = voitures.remove(id - 1);
        return voiture_supprimée;    }
}
