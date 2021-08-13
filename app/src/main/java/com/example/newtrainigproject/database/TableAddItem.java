package com.example.newtrainigproject.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.newtrainigproject.model.AddItemModel;

import java.util.ArrayList;
import java.util.List;

public class TableAddItem {
    private static final String COL_ID="_id";
    private static final String COL_STATE="state";
    private static final String COL_DISTRICT="district";
    private static final String COL_PIN="pin_code";
    private static final String TABLE_ITEM="item";

    public static final String CREATE_TABLE_ITEM=" create table if not exists " + TABLE_ITEM + " ( " + COL_ID + " integer primary key autoincrement, "
            + COL_STATE + " text not null, " + COL_DISTRICT + " text not null, " + COL_PIN + " integer not null )";
    public static final String DROP_TABLE_ITEM=" drop table if exists " + TABLE_ITEM;
    DataBaseHelper dbRegistration;
    Context context;
    public TableAddItem(Context context){
        this.context=context;
        dbRegistration=new DataBaseHelper(context);
    }
    public void insertIntoItem(AddItemModel mAddItemModel){
        SQLiteDatabase sqItem=dbRegistration.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_STATE,mAddItemModel.getState());
        values.put(COL_DISTRICT,mAddItemModel.getDistrict());
        values.put(COL_PIN,mAddItemModel.getPinCode());
        sqItem.insert(TABLE_ITEM,null,values);
        sqItem.close();
    }
    @SuppressLint("Range")
    public List<AddItemModel> getViewItems(){
        List<AddItemModel> modelList=new ArrayList<>();
        SQLiteDatabase sqItem=dbRegistration.getWritableDatabase();
        Cursor cursor=sqItem.rawQuery(" select * from " + TABLE_ITEM ,null);
        if(cursor!=null){
            if (cursor.moveToFirst()){
                do {
                    AddItemModel mAddItemModel = new AddItemModel();
                    mAddItemModel.setState(cursor.getString(cursor.getColumnIndex(COL_STATE)));
                    mAddItemModel.setDistrict(cursor.getString(cursor.getColumnIndex(COL_DISTRICT)));
                    mAddItemModel.setPinCode(cursor.getString(cursor.getColumnIndex(COL_PIN)));
                    modelList.add(mAddItemModel);
                }while (cursor.moveToNext());
            }
            cursor.close();
        }
        return modelList;
    }
    public boolean checkValidation(String state,String district){
        boolean validation=false;
        SQLiteDatabase sqItem=dbRegistration.getWritableDatabase();
        Cursor cursor =sqItem.rawQuery(" select * from " + TABLE_ITEM + " where " + COL_STATE + " = \"" + state + "\" and " + COL_DISTRICT + " = \"" + district + "\"",null);
        if (cursor!=null){
            if (cursor.moveToFirst()){
                validation=true;
            }
            cursor.close();
        }
        sqItem.close();
        return validation;
    }
}
