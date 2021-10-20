package models;

public class ModelAssurance {
    int id_assurance;
    String NomAssurance,Type,DateD,DateF;

    public ModelAssurance(int id_assurance, String nomAssurance, String type,String dateD, String dateF) {
        this.id_assurance = id_assurance;
        this.NomAssurance = nomAssurance;
        this.Type = type;
        this.DateD = dateD;
        this.DateF = dateF;
    }

    public int getId_assurance() {
        return id_assurance;
    }

    public void setId_assurance(int id_assurance) {
        this.id_assurance = id_assurance;
    }

    public String getNomAssurance() {
        return NomAssurance;
    }

    public void setNomAssurance(String nomAssurance) {
        NomAssurance = nomAssurance;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDateD() {
        return DateD;
    }

    public void setDateD(String dateD) {
        DateD = dateD;
    }

    public String getDateF() {
        return DateF;
    }

    public void setDateF(String dateF) {
        DateF = dateF;
    }
}
