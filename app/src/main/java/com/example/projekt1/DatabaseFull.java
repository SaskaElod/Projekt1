package com.example.projekt1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


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
        long ins=db.insert("Users.db",null,contentValues);
        if(ins==-1)return true;
        else return false;
    }
    public Onedata getData(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Onedata.name,
                new String[]{Onedata.question, Onedata.point},
                Onedata.question + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Onedata hobbie = new Onedata(
                cursor.getInt(cursor.getColumnIndex(Onedata.question)),
                cursor.getString(cursor.getColumnIndex(Onedata.point)));

        cursor.close();
        return hobbie;
    }
    public List<Onedata> getAllHobbie() {
        List<Onedata> hobbies = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Onedata.name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Onedata hobbie = new Onedata();
                hobbie.setId(cursor.getInt(cursor.getColumnIndex(Onedata.question)));
                hobbie.setData(cursor.getString(cursor.getColumnIndex(Onedata.point)));
                hobbies.add(hobbie);
            } while (cursor.moveToNext());
        }
        db.close();
        return hobbies;
    }
}
