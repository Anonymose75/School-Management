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

public class inscriptioncours extends AppCompatActivity {
    EditText id,titre,coeff,semestre,filiere;
    FirebaseDatabase database;
    DatabaseReference ref;
    Cours edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscriptioncours);
        id=findViewById(R.id.editText4);
       titre=findViewById(R.id.editText3);
       coeff=findViewById(R.id.editText);
        semestre=findViewById(R.id.editText2);
        filiere=findViewById(R.id.editText5);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("cours");
        edt=new Cours();

    }
    private void getvalues(){
        edt.setId(id.getText().toString());
        edt.setTitre(titre.getText().toString());
        edt.setCoeff(coeff.getText().toString());
        edt.setSemestre(semestre.getText().toString());
        edt.setFiliere(filiere.getText().toString());

    }

    public void inscrireCours(View view) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getvalues();
                ref.child(id.getText().toString()).setValue(edt);
                Toast.makeText(inscriptioncours.this,"reussite",Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
