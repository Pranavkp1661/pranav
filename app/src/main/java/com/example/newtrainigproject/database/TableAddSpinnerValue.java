package com.example.newtrainigproject.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.newtrainigproject.model.AddSpinnerValueModel;

import java.util.ArrayList;
import java.util.List;

public class TableAddSpinnerValue {
    private static final String COL_SP_ID="sp_id";
    private static final String COl_SP_NAME="sp_name";
    private static final String TABLE_ADD_SPINNER_VALUE="add_sp_value";

    public static final String CREATE_TABLE_ADD_SPINNER_VALUE =" create table if not exists " + TABLE_ADD_SPINNER_VALUE +
            " ( " + COL_SP_ID + " integer primary key autoincrement, " + COl_SP_NAME + " text unique  not null )";
    public static final String DROP_TABLE =" drop table if exists " + TABLE_ADD_SPINNER_VALUE;
    DataBaseHelper dataBaseHelper;
    Context context;
    public TableAddSpinnerValue(Context context){
        this.context=context;
        dataBaseHelper=new DataBaseHelper(context);
    }
    public long insertIntoAddSpinnerValue(AddSpinnerValueModel addSpinnerValueModel){
        SQLiteDatabase sqSpValue=dataBaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_SP_ID,addSpinnerValueModel.getSp_id());
        values.put(COl_SP_NAME,addSpinnerValueModel.getSp_name());
        return sqSpValue.insert(TABLE_ADD_SPINNER_VALUE,null,values);
    }
    @SuppressLint("Range")
    public List<AddSpinnerValueModel> getSpinner(){
        List<AddSpinnerValueModel> modelList=new ArrayList<>();
        SQLiteDatabase sqSpValue=dataBaseHelper.getWritableDatabase();
        Cursor cursor=sqSpValue.rawQuery("select * from " + TABLE_ADD_SPINNER_VALUE,null);
        if (cursor!=null){
            if (cursor.moveToFirst()){
                do {
                    AddSpinnerValueModel addSpinnerValueModel = new AddSpinnerValueModel();
                    addSpinnerValueModel.setSp_name(cursor.getString(cursor.getColumnIndex(COl_SP_NAME)));
                    modelList.add(addSpinnerValueModel);
                }while (cursor.moveToNext());
            }
        }
        cursor.close();
        return modelList;
    }
}
