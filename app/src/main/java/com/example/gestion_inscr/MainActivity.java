package com.example.gestion_inscr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
  EditText ed1;
  EditText ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);
    }

    public void authentifcation(View view) {
        // CASES ONE OF FIELD  IS EMPTY
          if(ed1.getText().toString().matches(""))
          {
                  Toast.makeText(MainActivity.this,"empty field",Toast.LENGTH_SHORT).show();
          }
          // cases field are non empty
          if(!ed1.getText().toString().matches("")){
              // variable i used it for verify if matricule and line are same.
              int ex=0;
              // READ FILE FROM RAW DIRECTORY
              InputStream file = getResources().openRawResource(R.raw.pwd);
              InputStreamReader inputreader = new InputStreamReader(file);
              BufferedReader buffreader = new BufferedReader(inputreader);
              // for read lines of file
              String line;

              try {
                  while (( line = buffreader.readLine()) != null && ex==0) {
                      if(ed1.getText().toString().matches(line) ){
                          line=buffreader.readLine();
                          if(ed2.getText().toString().matches(line))
                          ex=ex+1;
                      }
                  }
              } catch (IOException e) {
              }
               if(ex!=0){
                   Intent i=new Intent(MainActivity.this,dash.class);
                   startActivity(i);
               }else{
                   Toast.makeText(MainActivity.this,"incorrect information",Toast.LENGTH_SHORT).show();
               }

                      }
          }


}









