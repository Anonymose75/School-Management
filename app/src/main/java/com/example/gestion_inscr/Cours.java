package com.example.gestion_inscr;

public class Cours {
    String id;
    String titre;
    String coeff;
    String semestre;
    String filiere;

    public Cours() {
    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getCoeff() {
        return coeff;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setCoeff(String coeff) {
        this.coeff = coeff;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
}
