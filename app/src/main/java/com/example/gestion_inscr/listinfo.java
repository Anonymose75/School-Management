package com.example.gestion_inscr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
public class listinfo extends AppCompatActivity {
    ListView list;
    FirebaseDatabase db;
    DatabaseReference ref;
    ArrayList<String> matricule=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listes);
        //get student matricule
        Intent a=getIntent();
        final String matr=a.getStringExtra("matricule");
        list=findViewById(R.id.lis);
        // start an instance of db
        db=FirebaseDatabase.getInstance();
        // reference the root of student with specific matricule=matr in firbase
        ref=db.getReference("etudiant").child(matr);
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,matricule);
        list.setAdapter(arrayAdapter);
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                // stock the value of nom and prenom in value
                String value=dataSnapshot.getValue(String.class);
                matricule.add(dataSnapshot.child("").getKey()+":"+" "+value);
                // send any addtional noom and prenom to application
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


}
}
