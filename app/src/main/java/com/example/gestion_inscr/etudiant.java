package com.example.gestion_inscr;

public class etudiant {
   private String matricule;
   private String nom;
   private String prenom;
   private String ville;
   private String date;

 public etudiant(String matricule,String nom,String prenom,String ville,String date){
     this.matricule=matricule;
     this.nom=nom;
     this.prenom=prenom;
     this.ville=ville;
     this.date=date;
 }
    public etudiant() {
    }

    public String getMatricule() {
        return matricule;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public String getDate() {
        return date;
    }

    public void setMatricule(String Matricule) {
        this.matricule = Matricule;
    }

    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    public void setVille(String Ville) {
        this.ville = Ville;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }
    public boolean Nempty() {
        return matricule != null && nom != null && prenom != null && ville!= null && date != null;
    }
}