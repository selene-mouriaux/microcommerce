package com.ecommerce.microcommerce.model;

public class Voiture {

    private int id;
    private String modèle;
    private String marque;
    private String couleur;

    public Voiture() {
    }

    public Voiture(int id, String modèle, String marque, String couleur) {
        this.id = id;
        this.modèle = modèle;
        this.marque = marque;
        this.couleur = couleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModèle() {
        return modèle;
    }

    public void setModèle(String modèle) {
        this.modèle = modèle;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", modèle='" + modèle + '\'' +
                ", marque='" + marque + '\'' +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
