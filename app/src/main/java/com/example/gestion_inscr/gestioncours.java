package com.example.gestion_inscr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class gestioncours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestioncours);
    }

    public void ajouterCours(View view) {
        // go to page for insert cours data
        Intent i= new Intent(gestioncours.this,inscriptioncours.class);
        startActivity(i);
    }
 // this function delete cours from data base
    public void deleteCour(View view) {
        Intent a=new Intent(gestioncours.this,supprimercours.class);
        startActivity(a);
    }
// this function used for display information about cours with specific id
    public void allcours(View view) {
        Intent a=new Intent(gestioncours.this,infocours.class);
        startActivity(a);

    }

    public void rollback(View view) {
        finish();
    }
// modify course data
    public void modifiyCourse(View view) {
        Intent m= new Intent(gestioncours.this,modifiecours.class);
        startActivity(m);
    }
}
