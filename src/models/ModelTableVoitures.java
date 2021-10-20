package models;

import java.util.Date;

public class ModelTableVoitures {
    String Immatriculation,TypeCarburant,Marque,Model,Couleur,TypeVoiture;
    Date DateMiseCirculation;
    int Prix ;

    public ModelTableVoitures(String immatriculation,  String marque, String model, String couleur, int Prix) {
        Immatriculation = immatriculation;
        Marque = marque;
        Model = model;
        Couleur = couleur;
        this.Prix =Prix;
    }

    public String getImmatriculation() {
        return Immatriculation;
    }

    public String getTypeCarburant() {
        return TypeCarburant;
    }

    public String getMarque() {
        return Marque;
    }

    public String getModel() {
        return Model;
    }

    public String getCouleur() {
        return Couleur;
    }

    public String getTypeVoiture() {
        return TypeVoiture;
    }

    public Date getDateMiseCirculation() {
        return DateMiseCirculation;
    }

    public void setImmatriculation(String immatriculation) {
        Immatriculation = immatriculation;
    }

    public void setTypeCarburant(String typeCarburant) {
        TypeCarburant = typeCarburant;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setCouleur(String couleur) {
        Couleur = couleur;
    }

    public void setTypeVoiture(String typeVoiture) {
        TypeVoiture = typeVoiture;
    }

    public void setDateMiseCirculation(Date dateMiseCirculation) {
        DateMiseCirculation = dateMiseCirculation;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }
}
