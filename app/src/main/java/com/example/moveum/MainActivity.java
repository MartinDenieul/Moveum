package com.example.moveum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moveum.BDD.UserDBHelper;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    private TextView moveum;
    private EditText identity;
    private EditText mdp;
    private Button boutonValidation;
    private Button boutonCreation;
    private TextView textConnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveum = (TextView) findViewById(R.id.moveum);
        identity = (EditText) findViewById(R.id.identity);
        mdp = (EditText) findViewById(R.id.mdp);
        boutonValidation = (Button) findViewById(R.id.boutonValidation);
        boutonCreation = (Button) findViewById(R.id.boutonCreationCompte);
        textConnexion = (TextView) findViewById(R.id.textConnexion);
        final UserDBHelper DBHelperUser=new UserDBHelper(this);
        boutonValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                db = DBHelperUser.getWritableDatabase();
                String req="select * from " + UserDBHelper.USER_TABLE_NAME;
                Cursor c = db.rawQuery(req, null);
                c.moveToFirst();
                StringBuffer buffer = new StringBuffer();
                final String identityrecup= identity.getText().toString();


                    if (identityrecup == "zafar"){
                        Intent homeActivity = new Intent(MainActivity.this, home.class);
                        startActivity(homeActivity);
                }
                    else{
                        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {


                            buffer.append("Prenom : " + c.getString(1) + "\n");
                            buffer.append("Nom : " + c.getString(2) + "\n");
                            buffer.append("Identity : " + c.getString(3) + "\n");
                            buffer.append("MDP : " + c.getString(4) + "\n\n");

                        }
                        textConnexion.setText(String.valueOf(c.getString(3)));
                    }

        };
        });
        boutonCreation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                Intent creationCompte = new Intent(MainActivity.this,CreationCompteActivity.class);
                startActivity(creationCompte);
            }
        });
    }
}
