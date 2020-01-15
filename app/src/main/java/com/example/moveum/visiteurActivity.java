package com.example.moveum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class visiteurActivity extends AppCompatActivity {
    private Button nouveauParcours;
    private Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiteur);
        nouveauParcours = (Button) findViewById(R.id.newparcours);
        home = (Button) findViewById(R.id.retourhome);
        nouveauParcours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent nouveauParcoursActivity = new Intent(visiteurActivity.this, creationparcoursActivity.class);
                startActivity(nouveauParcoursActivity);
            }
        });
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent retouraccueil = new Intent(visiteurActivity.this, home.class);
                startActivity(retouraccueil);
            }
        });
    }
}
