package com.example.newtrainigproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbRegistration extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbTest";
    private static final int DATABASE_VERSION = 1;
    Context context;

    public DbRegistration(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DbLoginRegister.CREATE_TABLE_REGISTRATION);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DbLoginRegister.CREATE_TABLE_REGISTRATION);
        sqLiteDatabase.execSQL(DbLoginRegister.DROP_TABLE_REGISTRATION);
    }
}
