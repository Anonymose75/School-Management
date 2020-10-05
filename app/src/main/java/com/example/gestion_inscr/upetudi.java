package com.example.gestion_inscr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class upetudi extends AppCompatActivity {
    EditText matr;
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    DatabaseReference updateData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upetudi);
        matr=findViewById(R.id.editText3);
        ed1=findViewById(R.id.textView5);
        ed2=findViewById(R.id.textView6);
        ed3=findViewById(R.id.textView7);
        ed4=findViewById(R.id.textView8);
        updateData = FirebaseDatabase.getInstance().getReference("etudiant").child(matr.getText().toString());
    }

    public void enregistrer(View view) {
        if(matr.getText().toString().matches("")){
            Toast.makeText(upetudi.this,"empty id",Toast.LENGTH_SHORT).show();
        }
        if(!matr.getText().toString().matches("")){

            if(!ed1.getText().toString().matches("")){
                updateData.child(matr.getText().toString()).child("nom").setValue(ed1.getText().toString());
            }
            if(!ed2.getText().toString().matches("")){
                updateData.child(matr.getText().toString()).child("prenom").setValue(ed2.getText().toString());
            }
            if(!ed3.getText().toString().matches("")){
                updateData.child(matr.getText().toString()).child("ville").setValue(ed3.getText().toString());
            }
            if(!ed4.getText().toString().matches("")){
                updateData.child(matr.getText().toString()).child("date").setValue(ed4.getText().toString());
            }
        }
    }
}
