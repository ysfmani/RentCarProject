package models;

public class ModelChauffeur {
    int idChauff,tel_cahuff;
    String nom,prenom,cin,DispoChauff;

    public ModelChauffeur(int idChauff, int tel_cahuff, String nom, String prenom, String cin, String DispoChauff) {
        this.idChauff = idChauff;
        this.tel_cahuff = tel_cahuff;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        DispoChauff = DispoChauff;
    }

    public int getIdChauff() {
        return idChauff;
    }

    public void setIdChauff(int idChauff) {
        this.idChauff = idChauff;
    }

    public int gettel_cahuff() {
        return tel_cahuff;
    }

    public void settel_cahuff(int tel_cahuff) {
        this.tel_cahuff = tel_cahuff;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getDispoCHauff() {
        return DispoChauff;
    }

    public void setDispoCHauff(String DispoChauff) {
        DispoChauff = DispoChauff;
    }
}
