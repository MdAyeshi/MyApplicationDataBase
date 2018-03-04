package com.example.mdjubairayeshi.myapplicationdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Md Jubair Ayeshi on 4/24/2017.
 */

public class DataBase extends SQLiteOpenHelper {

    SQLiteDatabase db;
    DataBase(Context context)
    {
        super(context,"DbName",null,1);
         db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table my_table(id integer primary key autoincrement,name text(20),Pass text(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist my_table");
        onCreate(db);
    }
    public void setdata(String a,String b)
    {
        ContentValues cv=new ContentValues();
        cv.put("name",a);
        cv.put("Pass",b);
        db.insert("my_table",null,cv);
        db.close();


    }
    public Cursor getData()
    {
        db=getReadableDatabase();


        return db.rawQuery("select * from my_table",null);

    }
}
