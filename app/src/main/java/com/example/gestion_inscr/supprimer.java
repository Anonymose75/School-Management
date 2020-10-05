package com.example.gestion_inscr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// this activity used fot deleting a student with speceific matricule
public class supprimer extends AppCompatActivity {
EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);
        ed=findViewById(R.id.editText);
    }
// delete function with specific matricule ed.getText().toString
    public void DELETE(View view) {
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("etudiant").child(ed.getText().toString());
        DatabaseReference db1= FirebaseDatabase.getInstance().getReference("Inscription").child(ed.getText().toString());
        // delete etudiant
        db.removeValue();
        // delete student inscription
        db1.removeValue();
        Toast.makeText(supprimer.this,"student has been deleted",Toast.LENGTH_SHORT).show();
    }
}
