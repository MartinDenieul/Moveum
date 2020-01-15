package com.example.moveum.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MuseeDBHelper extends SQLiteOpenHelper {
    public static final String MUSEE_KEY = "id";
    public static final String MUSEE_NOM = "nom";
    public static final String MUSEE_APPID = "appid";
    public static final String MUSEE_APPTOKEN="apptoken";
    public static final String MUSEE_TABLE_NAME = "musee";
    public static final String MUSEE_TABLE_CREATE =
            "CREATE TABLE " + MUSEE_TABLE_NAME + " (" +
                    MUSEE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    MUSEE_NOM + " TEXT, " +
                    MUSEE_APPID + " TEXT, " +
                    MUSEE_APPTOKEN + " TEXT) ";



    public MuseeDBHelper(Context context) {
        super(context, "dbmoveum", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MUSEE_TABLE_CREATE);
    }
    public static final String MUSEE_TABLE_DROP = "DROP TABLE IF EXISTS " + MUSEE_TABLE_NAME ;

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MUSEE_TABLE_DROP);
        onCreate(db);
    }

    public void ajouterMusee(String nom, String appid, String apptoken){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(this.MUSEE_NOM,nom);
        cv.put(this.MUSEE_APPID, appid);
        cv.put(this.MUSEE_APPTOKEN, apptoken);


        db.insert(this.MUSEE_TABLE_NAME, null, cv);




    }
}
