package com.example.gestion_inscr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class inscrireetudiantcour extends AppCompatActivity {
    EditText idcours,matricule,année,note,filiere;
    FirebaseDatabase database;
    DatabaseReference ref;
    InscriptionEtudiant edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrireetudiantcour);
        idcours=findViewById(R.id.editText4);
        matricule=findViewById(R.id.editText3);
        année=findViewById(R.id.editText);
        note=findViewById(R.id.editText2);
        filiere=findViewById(R.id.editText5);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Inscription");
        edt=new InscriptionEtudiant();
}
    private void getvalues(){
        edt.setId(idcours.getText().toString());
        edt.setMatricule(matricule.getText().toString());
        edt.setAnnée(année.getText().toString());
        edt.setNote(note.getText().toString());
        edt.setFiliere(filiere.getText().toString());

    }

    public void inscrireEtudCours(View view) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getvalues();
                ref.child(idcours.getText().toString()).child(matricule.getText().toString()).child(année.getText().toString()).setValue(edt);
                Toast.makeText(inscrireetudiantcour.this,"reussite",Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
