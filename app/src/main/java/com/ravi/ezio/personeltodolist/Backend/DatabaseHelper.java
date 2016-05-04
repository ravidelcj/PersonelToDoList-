package com.ravi.ezio.personeltodolist.Backend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ezio on 4/5/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    Context context;
    public DatabaseHelper(Context context) {
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

    public List<CustomToDoType> getAllToDo()
    {
        List<CustomToDoType> list=new ArrayList<CustomToDoType>();
        String query="SELECT * FROM todolist";

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cs=db.rawQuery(query,null);
        while(cs.moveToNext())
        {
            CustomToDoType custom=new CustomToDoType();
            custom.title=cs.getString(cs.getColumnIndex("title"));
            custom.detail=cs.getString(cs.getColumnIndex("detail"));
            custom.time=cs.getString(cs.getColumnIndex("time"));
            custom.date=cs.getString(cs.getColumnIndex("date"));
            custom.location=cs.getString(cs.getColumnIndex("location"));

            list.add(custom);
        }
        return list;
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
