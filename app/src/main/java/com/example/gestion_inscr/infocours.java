package com.example.gestion_inscr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.Callable;

public class infocours extends AppCompatActivity {
    EditText id;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infocours);
        id=findViewById(R.id.editText3);
        tv2=findViewById(R.id.textView5);
        tv3=findViewById(R.id.textView6);
        tv4=findViewById(R.id.textView7);
        tv1=findViewById(R.id.textView8);
        ref = FirebaseDatabase.getInstance().getReference("cours");
    }

    // this fucntion used for load data course from data base to android
    public void affiche(View view) {
        ref.child(id.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              Cours  user = dataSnapshot.getValue(Cours.class);

                tv2.setText(user.getTitre());
                tv3.setText(user.getCoeff());
                tv4.setText(user.getSemestre());
                tv1.setText(user.getFiliere());
            }

            @Override
            public void onCancelled(DatabaseError error) {
// Failed to read value
                Toast.makeText(infocours.this, "error", Toast.LENGTH_SHORT).show();;
            }
        });
    }

}

