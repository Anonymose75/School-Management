package com.example.gestion_inscr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class inscription extends AppCompatActivity {
EditText matricule,nom,prenom,ville,date;
FirebaseDatabase database;
DatabaseReference ref;
etudiant edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        matricule=findViewById(R.id.editText4);
        nom=findViewById(R.id.editText3);
        prenom=findViewById(R.id.editText);
        ville=findViewById(R.id.editText2);
        date=findViewById(R.id.editText5);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("etudiant");
        edt=new etudiant();

    }
private void getvalues(){
        edt.setMatricule(matricule.getText().toString());
        edt.setNom(nom.getText().toString());
        edt.setPrenom(prenom.getText().toString());
        edt.setVille(ville.getText().toString());
        edt.setDate(date.getText().toString());

}

    public void inscrire(View view) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getvalues();
                if(edt.Nempty()){
                  ref.child(matricule.getText().toString()).setValue(edt);
                  Toast.makeText(inscription.this,"reussite",Toast.LENGTH_SHORT).show();
                  finish();
                } else{
                    Toast.makeText(inscription.this,"champs n'est pas valide",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}


