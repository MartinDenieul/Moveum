package com.example.moveum.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OeuvreDBHelper extends SQLiteOpenHelper {
    public static final String OEUVRE_KEY = "id";
    public static final String OEUVRE_DESCRIPTION = "description";
    public static final String OEUVRE_NOM = "nom";
    public static final String OEUVRE_ARTISTE = "artiste";
    public static final String OEUVRE_ANNEE="annee";
    public static final String OEUVRE_STYLE="style";
    public static final String OEUVRE_TABLE_NAME = "oeuvre";
    public static final String OEUVRE_TABLE_CREATE =
            "CREATE TABLE " + OEUVRE_TABLE_NAME + " (" +
                    OEUVRE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    OEUVRE_NOM + " TEXT, " +
                    OEUVRE_ARTISTE + " TEXT, " +
                    OEUVRE_ANNEE + " TEXT, " +
                    OEUVRE_STYLE + " TEXT, " +
                    OEUVRE_DESCRIPTION + " TEXT, " +
                    "img BLOB NOT NULL)";

    public OeuvreDBHelper(Context context) {
        super(context, "dbmoveum", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(OEUVRE_TABLE_CREATE);
    }
    public static final String OEUVRE_TABLE_DROP = "DROP TABLE IF EXISTS " + OEUVRE_TABLE_NAME ;

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(OEUVRE_TABLE_DROP);
        onCreate(db);
    }

    public boolean insertImage(String nom, String artiste, String annee, String style, String description, String chemin){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            FileInputStream fs = new FileInputStream(chemin);
            byte[] imgbyte = new byte[fs.available()];
            fs.read(imgbyte);
            ContentValues cv = new ContentValues();
            cv.put(this.OEUVRE_NOM,nom);
            cv.put(this.OEUVRE_ARTISTE, artiste);
            cv.put(this.OEUVRE_ANNEE, annee);
            cv.put(this.OEUVRE_STYLE, style);
            cv.put(this.OEUVRE_DESCRIPTION, description);
            cv.put("img", imgbyte);
            db.insert(this.OEUVRE_TABLE_NAME, null, cv);
            fs.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

    }
}
