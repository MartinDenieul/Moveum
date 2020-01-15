package com.example.moveum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class aproposdemoiActivity extends AppCompatActivity {
    private EditText prenom;
    private EditText nom;
    private EditText age;
    private EditText adressemail;
    private Button enregistrer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aproposdemoi);
        prenom = (EditText) findViewById(R.id.prenom);
        nom = (EditText) findViewById(R.id.nom);
        age = (EditText) findViewById(R.id.age);
        adressemail = (EditText) findViewById(R.id.adressemail);
        enregistrer = (Button) findViewById(R.id.enregistrer);
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent enregistrer_aproposdemoi = new Intent(aproposdemoiActivity.this, home.class);
                startActivity(enregistrer_aproposdemoi);
            }
        });
    }
}
