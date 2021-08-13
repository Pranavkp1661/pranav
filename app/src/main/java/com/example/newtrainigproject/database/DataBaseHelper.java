package com.example.newtrainigproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbTest";
    private static final int DATABASE_VERSION = 3;
    Context context;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TableLoginRegister.CREATE_TABLE_REGISTRATION);
        sqLiteDatabase.execSQL(TableAddItem.CREATE_TABLE_ITEM);
        sqLiteDatabase.execSQL(TableAddSpinnerValue.CREATE_TABLE_ADD_SPINNER_VALUE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TableLoginRegister.DROP_TABLE_REGISTRATION);
        sqLiteDatabase.execSQL(TableLoginRegister.CREATE_TABLE_REGISTRATION);
        sqLiteDatabase.execSQL(TableAddItem.DROP_TABLE_ITEM);
        sqLiteDatabase.execSQL(TableAddItem.CREATE_TABLE_ITEM);
        sqLiteDatabase.execSQL(TableAddSpinnerValue.DROP_TABLE);
        sqLiteDatabase.execSQL(TableAddSpinnerValue.CREATE_TABLE_ADD_SPINNER_VALUE);

    }
}
