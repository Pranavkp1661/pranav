package com.example.newtrainigproject.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.newtrainigproject.model.LoginRegistrationModel;

public class DbLoginRegister {
    private static final String COl_ID = "_id";
    private static final String COL_NAME="name";
    private static final String COl_U_NAME = "u_name";
    private static final String COL_PASS = "password";
    private static final String COL_EMAIL = "email";
    private static final String COL_PHONE = "phone";
    private static final String COL_ADDRESS = "address";
    private static final String COL_AGE = "age";
    private static final String COl_DOB = "date_of_birth";
    private static final String COL_GENDER = "gender";
    private static final String COL_HOBBIES = "hobbies";
    private static final String TABLE_REGISTRATION = "registration";

    public static final String CREATE_TABLE_REGISTRATION = "create table if not exists " + TABLE_REGISTRATION +
            " ( " + COl_ID + " integer primary key autoincrement, " + COL_NAME + " text not null, " + COl_U_NAME + " text not null, " + COL_PASS + " text not null, " +
            COL_EMAIL + " text not null, " + COL_ADDRESS + " text not null, " + COL_PHONE + " text not null, " + COL_AGE + " integer not null, "
            + COl_DOB + " text not null, " + COL_GENDER + " text not null, " + COL_HOBBIES + " text not null )";
    public static final String DROP_TABLE_REGISTRATION = " drop table if exists " + TABLE_REGISTRATION;
    DbRegistration dbRegistration;
    Context context;

    public DbLoginRegister(Context context) {
        this.context = context;
        dbRegistration = new DbRegistration(context);
    }

    public void insertIntoRegistration(LoginRegistrationModel mLoginRegistrationModel) {
        SQLiteDatabase sqReg = dbRegistration.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME,mLoginRegistrationModel.getName());
        values.put(COl_U_NAME, mLoginRegistrationModel.getUsername());
        values.put(COL_PASS, mLoginRegistrationModel.getPassword());
        values.put(COL_EMAIL, mLoginRegistrationModel.getEmail());
        values.put(COL_PHONE, mLoginRegistrationModel.getPhone());
        values.put(COL_ADDRESS, mLoginRegistrationModel.getAddress());
        values.put(COL_AGE, mLoginRegistrationModel.getAge());
        values.put(COl_DOB, mLoginRegistrationModel.getDob());
        values.put(COL_GENDER, mLoginRegistrationModel.getGender());
        values.put(COL_HOBBIES, mLoginRegistrationModel.getHobbies());
        sqReg.insert(TABLE_REGISTRATION, null, values);
    }

    @SuppressLint("Range")
    public LoginRegistrationModel checkRegistration(String uname, String password) {
        LoginRegistrationModel mLoginRegistrationModel = new LoginRegistrationModel();
        SQLiteDatabase sqReg = dbRegistration.getReadableDatabase();
        Cursor cursor = sqReg.rawQuery(" select * from " + TABLE_REGISTRATION + " where " + COl_U_NAME + " = \"" + uname + "\" and " + COL_PASS
                + " = " + password, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                mLoginRegistrationModel.setName(cursor.getString(cursor.getColumnIndex(COL_NAME)));
                mLoginRegistrationModel.setUsername(cursor.getString(cursor.getColumnIndex(COl_U_NAME)));
                mLoginRegistrationModel.setPassword(cursor.getString(cursor.getColumnIndex(COL_PASS)));
                mLoginRegistrationModel.setEmail(cursor.getString(cursor.getColumnIndex(COL_EMAIL)));
                mLoginRegistrationModel.setPhone(cursor.getString(cursor.getColumnIndex(COL_PHONE)));
                mLoginRegistrationModel.setAddress(cursor.getString(cursor.getColumnIndex(COL_ADDRESS)));
                mLoginRegistrationModel.setAge(cursor.getInt(cursor.getColumnIndex(COL_AGE)));
                mLoginRegistrationModel.setDob(cursor.getString(cursor.getColumnIndex(COl_DOB)));
                mLoginRegistrationModel.setGender(cursor.getString(cursor.getColumnIndex(COL_GENDER)));
                mLoginRegistrationModel.setHobbies(cursor.getString(cursor.getColumnIndex(COL_HOBBIES)));
            }
            cursor.close();
        }
        sqReg.close();
        return mLoginRegistrationModel;
    }

}
