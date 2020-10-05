package com.example.gestion_inscr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class modifiecours extends AppCompatActivity {
    EditText id;
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    DatabaseReference updateData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifiecours);
        id=findViewById(R.id.editText3);
        ed1=findViewById(R.id.textView5);
        ed2=findViewById(R.id.textView6);
        ed3=findViewById(R.id.textView7);
        ed4=findViewById(R.id.textView8);
        updateData = FirebaseDatabase.getInstance().getReference("cours").child(id.getText().toString());

    }

    public void save(View view) {
        if(id.getText().toString().matches("")){
            Toast.makeText(modifiecours.this,"empty id",Toast.LENGTH_SHORT).show();
        }
        if(!id.getText().toString().matches("")){

                    if(!ed1.getText().toString().matches("")){
                            updateData.child(id.getText().toString()).child("titre").setValue(ed1.getText().toString());
                    }
                   if(!ed2.getText().toString().matches("")){
                           updateData.child(id.getText().toString()).child("coeff").setValue(ed2.getText().toString());
                    }
                   if(!ed3.getText().toString().matches("")){
                          updateData.child(id.getText().toString()).child("semestre").setValue(ed3.getText().toString());
                            }
                   if(!ed4.getText().toString().matches("")){
                          updateData.child(id.getText().toString()).child("filiere").setValue(ed4.getText().toString());
                        }
        }

    }
}
