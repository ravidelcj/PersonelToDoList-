package com.ravi.ezio.personeltodolist.Backend;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ezio on 4/5/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    Context context;
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TODO.db", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable="Create Table todolist(_id Integer Primary Key,title Text,detail Text,location Text,date Text,time Text)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addToDo(CustomToDoType data)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",data.title);
        contentValues.put("detail",data.detail);
        contentValues.put("location",data.location);
        contentValues.put("date",data.date);
        contentValues.put("time",data.time);
        db.insert("todolist",null,contentValues);
    }
}
