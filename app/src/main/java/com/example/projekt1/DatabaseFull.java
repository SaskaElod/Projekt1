package com.example.projekt1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseFull extends SQLiteOpenHelper {

    public DatabaseFull(Context context){
        super(context,"Select.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create table user(name text primary key,nameItem text,valueItem string)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int OldVersion,int newVersion){
        db.execSQL("drop table if exists user");
    }

    public boolean insert(String name,String nameItem,String valueItem){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("nameItem",nameItem);
        contentValues.put("valueItem",valueItem);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1)return true;
        else return false;
    }
}
