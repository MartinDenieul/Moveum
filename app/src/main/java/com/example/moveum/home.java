package com.example.moveum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class home extends AppCompatActivity {
    private Button aproposdemoi;
    private Button evisiteur;
    private Button ecreateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        aproposdemoi = (Button) findViewById(R.id.aproposdemoi);
        evisiteur = (Button) findViewById(R.id.espace_visiteur);
        ecreateur = (Button) findViewById(R.id.espace_createur);
        evisiteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent evisiteurActivity = new Intent(home.this, visiteurActivity.class);
                startActivity(evisiteurActivity);
            }
        });
        aproposdemoi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent aproposdemoiActivity = new Intent(home.this, aproposdemoiActivity.class);
                startActivity(aproposdemoiActivity);
            }
        });
    }
}
