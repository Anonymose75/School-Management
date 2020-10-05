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

public class supprimercours extends AppCompatActivity {
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimercours);
        ed=findViewById(R.id.editText);
    }

    // delete function with specific id= ed.getText().toString
    public void DELETEcours(View view) {
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("cours").child(ed.getText().toString());
        // delete course
        db.removeValue();
        // delete course inscription
        Toast.makeText(supprimercours.this,"course has been deleted",Toast.LENGTH_SHORT).show();
    }
}
