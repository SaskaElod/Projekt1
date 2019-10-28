package com.example.projekt1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseFull extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Users.db";;
    private static  final String TABLE_NAME="userdata";
    private static final String COLUMN_ID="id";
    private static  final String COLUMN_NAME="name";
    private static final String COLUMN_QUESTION="quest";
    private static final String  COLUMN_ANSWER="answer";


    SQLiteDatabase database;




    public DatabaseFull(Context context){
        super(context,DATABASE_NAME,null,1);
        database=getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME+ "  ( "+ COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+ COLUMN_NAME + " TEXT ,"+ COLUMN_QUESTION+ " TEXT ,"+ COLUMN_ANSWER+ " TEXT "+")");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int OldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(String name,String question,String answer){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_QUESTION,question);
        contentValues.put(COLUMN_ANSWER,answer);
       long result = db.insert(TABLE_NAME,null,contentValues);
       if(result==-1)
       {return false;}
       else{return true;}

    }
    public Onedata getData(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Onedata.TABLE_NAME,
                new String[]{Onedata.name, Onedata.name},
                Onedata.name + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Onedata dates = new Onedata(
                cursor.getInt(cursor.getColumnIndex(Onedata.name)),
                cursor.getString(cursor.getColumnIndex(Onedata.name)));

        cursor.close();
        return dates;
    }
    public List<Onedata> getAllData() {
        List<Onedata> Dates = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Onedata dates = new Onedata();
                dates.setId(cursor.getInt(cursor.getColumnIndex(Onedata.name)));
                dates.setData(cursor.getString(cursor.getColumnIndex(Onedata.name)));
                Dates.add(dates);
            } while (cursor.moveToNext());
        }
        db.close();
        return Dates;
    }
}
