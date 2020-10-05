package com.example.gestion_inscr;

public class InscriptionEtudiant {
    String id;
    String matricule;
    String année;
    String note;
    String filiere;

    public InscriptionEtudiant() {
    }

    public String getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getAnnée() {
        return année;
    }

    public String getNote() {
        return note;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setAnnée(String année) {
        this.année = année;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
}
