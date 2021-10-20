package models;

import java.util.Date;

public class ModelTableClient
{
    int id_client,tel;
    String nom, prenom, adresse, etatCiv,cin,mdp,DateNaissance;
    public ModelTableClient(int id_client,String nom, String prenom, int tel, String adresse, String etatCiv,String DateNaissance, String mdp , String cin) {
        this.id_client = id_client;
        this.tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.etatCiv = etatCiv;
        this.cin=cin;
        this.mdp=mdp;
        this.DateNaissance=DateNaissance;
    }
    public int getId_client() {
        return id_client;
    }
    public int getTel() {
        return tel;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public String getEtatCiv() {
        return etatCiv;
    }
    public String getCin() {
        return cin;
    }
    public String getMdp() {
        return mdp;
    }
    public String getDateNaissance() {
        return DateNaissance;
    }
    public void setId_client(int id_client) {
        this.id_client= id_client;
    }
    public void setTel(int tel) {
        this.tel = tel;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setEtatCiv(String etatCiv) {
        this.etatCiv = etatCiv;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public void setDateNaissance(String date_naissance) {
        this.DateNaissance = DateNaissance;
    }
}
