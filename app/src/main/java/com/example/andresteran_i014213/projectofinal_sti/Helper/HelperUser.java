package com.example.andresteran_i014213.projectofinal_sti.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kenet on 24/05/2017.
 */

public class HelperUser extends SQLiteOpenHelper {

    private static final String LOGTAG = "LOGTAG";
    public static final String DATABASE_NAME = "users";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_STATUS = "status";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_EMAIL + " TEXT," +
                    COLUMN_USERNAME + " TEXT," +
                    COLUMN_PASSWORD + " TEXT," +
                    COLUMN_STATUS + " TEXT" +
                    ")";

    public static final String TABLE_BUSES = "buses";
    public static final String COLUMN_ROUTE = "route";
    public static final String COLUMN_NEIGHBORHOD = "neighborhood";

    public static final String TABLE_CREATE_BUSES =
            "CREATE TABLE " + TABLE_BUSES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ROUTE + " TEXT, " +
                    COLUMN_NEIGHBORHOD + " TEXT" +
                    ")";

    public static final String TABLE_FAVORITES_BUSES_USERS="favoritesBusesUsers";
    public static final String COLUMN_ID_USER = "idUser";
    public static final String COLUMN_ID_BUS = "idBus";

    public static final String TABLE_CREATE_FAVORITES =
            "CREATE TABLE " + TABLE_FAVORITES_BUSES_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ID_USER + " INTEGER, " +
                    COLUMN_ID_BUS + " INTEGER" +
                    ")";


    public HelperUser(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_BUSES);
        db.execSQL(TABLE_CREATE_FAVORITES);
        Log.i(LOGTAG, "Tabla de usuarios creada correctamente.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_BUSES);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FAVORITES_BUSES_USERS);
        onCreate(db);
    }
}
