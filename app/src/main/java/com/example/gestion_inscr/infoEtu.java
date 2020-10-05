package com.example.gestion_inscr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class infoEtu extends AppCompatActivity {
 EditText matric;
 TextView tv1;
 TextView tv2;
 TextView tv3;
 TextView tv4;

 DatabaseReference ref,demoRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_etu);
        matric=findViewById(R.id.editText3);
        tv2=findViewById(R.id.textView5);
        tv3=findViewById(R.id.textView6);
        tv4=findViewById(R.id.textView7);
        tv1=findViewById(R.id.textView8);
        ref = FirebaseDatabase.getInstance().getReference("etudiant");
    }

// this fucntion used for load data from data base to android
    public void load(View view) {
       ref.child(matric.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               etudiant user = dataSnapshot.getValue(etudiant.class);

                tv2.setText(user.getNom());
                tv3.setText(user.getPrenom());
                tv4.setText(user.getVille());
                tv1.setText(user.getDate());
            }

            @Override
            public void onCancelled(DatabaseError error) {
// Failed to read value
                Toast.makeText(infoEtu.this, "error", Toast.LENGTH_SHORT).show();;
            }
        });
    }



}
