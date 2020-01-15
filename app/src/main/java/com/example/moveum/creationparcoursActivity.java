package com.example.moveum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class creationparcoursActivity extends AppCompatActivity {
    private EditText nomDuParcours;
    private EditText nomDuMusee;
    private Button enregistrerparcours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creationparcours);
        nomDuParcours = (EditText) findViewById(R.id.nomparcours);
        nomDuMusee  = (EditText) findViewById(R.id.nommusee);
        enregistrerparcours = (Button) findViewById(R.id.enregistrerparcours);
        enregistrerparcours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent enregistrerleparcours = new Intent(creationparcoursActivity.this, visiteurActivity.class);
                startActivity(enregistrerleparcours);
            }
        });
    }
}
