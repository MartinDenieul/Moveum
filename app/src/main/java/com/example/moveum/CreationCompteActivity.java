package com.example.moveum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moveum.BDD.UserDBHelper;

import static com.example.moveum.BDD.UserDBHelper.USER_TABLE_NAME;

public class CreationCompteActivity extends AppCompatActivity {

    SQLiteDatabase db;



    private Integer id;
    private EditText prenom;
    private EditText nom;
    private EditText identity;
    private EditText mdp;
    private EditText age;
    private EditText mail;
    private Button valider;
    private TextView affichage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);
        final UserDBHelper DBHelperUser=new UserDBHelper(this);

        prenom = (EditText) findViewById(R.id.prenom);
        nom = (EditText) findViewById(R.id.nom);
        identity = (EditText) findViewById(R.id.identity);
        mdp = (EditText) findViewById(R.id.mdp);
        age = (EditText) findViewById(R.id.age);
        valider = (Button) findViewById(R.id.valider);
        mail= (EditText) findViewById(R.id.mail);
        affichage = (TextView) findViewById(R.id.affichage);



        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                final String uprenom = prenom.getText().toString();
                final String unom = nom.getText().toString();
                final String uidentity = identity.getText().toString();
                final String umdp = mdp.getText().toString();
                final String uage = age.getText().toString();
                final String umail = mail.getText().toString();
                db = DBHelperUser.getWritableDatabase();
                ContentValues value = new ContentValues();
                value.put(UserDBHelper.USER_PRENOM, uprenom);
                value.put(UserDBHelper.USER_NOM, unom);
                value.put(UserDBHelper.USER_IDENTITY, uidentity);
                value.put(UserDBHelper.USER_MDP, umdp);
                value.put(UserDBHelper.USER_AGE, uage);
                value.put(UserDBHelper.USER_MAIL, umail);
                db.insert(USER_TABLE_NAME, null, value);

                String req="select * from " + USER_TABLE_NAME;
                StringBuffer buffer = new StringBuffer();
                Cursor c = db.rawQuery(req, null);

                c.moveToFirst();
                for(c.moveToLast(); !c.isFirst(); c.moveToPrevious()) {


                    buffer.append("Prenom : " + c.getString(1) + "\n");
                    buffer.append("Nom : " + c.getString(2) + "\n");
                    buffer.append("Identity : " + c.getString(3) + "\n");
                    buffer.append("MDP : " + c.getString(4) + "\n\n");

                }



                affichage.setText(String.valueOf(buffer));
                c.close();
                Intent retourauth = new Intent(CreationCompteActivity.this,MainActivity.class);
                startActivity(retourauth);

            }
        });
    }
}
