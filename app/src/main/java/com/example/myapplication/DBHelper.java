package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "userdb";


    private static final int DB_VERSION = 1;


    private static final String TABLE_NAME = "form";


    private static final String ID_COL = "id";


    private static final String NAME_COL = "name";


    private static final String EMAIL_COL = "email";


    private static final String PHONE_COL = "phone";


    private static final String ADDRESS_COL = "address";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PHONE_COL + " NUMBER,"
                + ADDRESS_COL + " TEXT)";


        db.execSQL(query);
    }


    public void addNewCourse(String Name, String Email, String Phone, String Address) {


        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();


        values.put(NAME_COL, Name);
        values.put(EMAIL_COL, Email);
        values.put(PHONE_COL, Phone);
        values.put(ADDRESS_COL, Address);


        db.insert(TABLE_NAME, null, values);


        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}