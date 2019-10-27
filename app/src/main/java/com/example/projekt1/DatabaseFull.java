package com.example.projekt1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseFull extends SQLiteOpenHelper {

    public static final  String DATABAS_NAME="Users.db";
    public static final String TABLE_NAME="users_table";
    public static final String COLUMN1="ID";
    public static final String COLUMN2="username";
    public static final String COLUMN3="questname";
    public static final String COLUMN4="answer";



    public DatabaseFull(Context context){
        super(context,"Users.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create table users_table(ID INTEGER primary key,username text ,questname text,answer string)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int OldVersion,int newVersion){
        db.execSQL("drop table if exists users_table");
        this.onCreate(db);
    }

    public boolean insert(String username,String questname,String answer){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN2,username);
        contentValues.put(COLUMN3,questname);
        contentValues.put(COLUMN4,answer);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1)return true;
        else return false;
    }
}
