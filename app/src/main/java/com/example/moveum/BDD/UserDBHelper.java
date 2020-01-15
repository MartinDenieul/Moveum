package com.example.moveum.BDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDBHelper extends SQLiteOpenHelper {
    public static final String USER_KEY = "id";
    public static final String USER_PRENOM = "prenom";
    public static final String USER_NOM = "nom";
    public static final String USER_IDENTITY="identity";
    public static final String USER_MDP="mdp";
    public static final String USER_AGE="age";
    public static final String USER_MAIL="mail";
    public static final String USER_TABLE_NAME = "User";
    public static final String USER_TABLE_CREATE =
            "CREATE TABLE " + USER_TABLE_NAME + " (" +
                    USER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    USER_PRENOM + " TEXT, " +
                    USER_NOM + " TEXT, " +
                    USER_IDENTITY + " TEXT, " +
                    USER_MDP + " TEXT, " +
                    USER_AGE + " TEXT, " +
                    USER_MAIL + " TEXT)";

    public UserDBHelper(Context context) {
        super(context, "dbmoveum", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);
    }
    public static final String USER_TABLE_DROP = "DROP TABLE IF EXISTS " + USER_TABLE_NAME ;

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(USER_TABLE_DROP);
        onCreate(db);
    }
}
