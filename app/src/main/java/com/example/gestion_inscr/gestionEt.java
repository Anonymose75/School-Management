package com.example.gestion_inscr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class gestionEt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_et);
    }

    public void rollback(View view) {
        // go back
        finish();
    }

    public void exit(View view) {
        // exit page and go the main page
        System.exit(0);
    }

    public void ajouter(View view) {
        // go to page for isnert student data
        Intent i= new Intent(gestionEt.this,inscription.class);
        startActivity(i);
    }

    public void allEtudiant(View view) {
        Intent u=new Intent(gestionEt.this,listes.class);
        startActivity(u);
    }
// this function display information about student by using matricule identification
    public void affiche_etud(View view) {
        Intent a=new Intent(gestionEt.this,infoEtu.class);
        startActivity(a);

    }

    public void deleteEtu(View view) {
        Intent a=new Intent(gestionEt.this,supprimer.class);
        startActivity(a);
    }
//update data student
    public void fonction4(View view) {
        Intent up= new Intent(gestionEt.this,upetudi.class);
        startActivity(up);
    }
}
