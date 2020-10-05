package com.example.gestion_inscr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class dash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
    }

    public void quitter(View view) {
        System.exit(0);
    }

    public void help(View view) {
        Intent su= new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.emi.ac.ma/ecole/administration"));
        startActivity(su);
    }

    public void fonction4(View view) {
        Intent i=new Intent(dash.this,gestionEt.class);
        startActivity(i);
    }


 // THIS FUNCTION DISPLAY ALL COURS
    public void listCours(View view) {
        Intent u=new Intent(dash.this,listecours.class);
        startActivity(u);

    }


 // FUNCTION FOR GO TO INTENT GESTION OF COURSES
    public void gestionCours(View view) {
        Intent r=new Intent(dash.this,gestioncours.class);
        startActivity(r);

    }
// inscrire etudiant in course
    public void inscription(View view) {
            Intent r=new Intent(dash.this,inscrireetudiantcour.class);
            startActivity(r);

        }


}
