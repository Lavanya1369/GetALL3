package com.l9ench.getall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sai on 1/23/2017.
 */

public class Databasehelper extends SQLiteOpenHelper {

    public static final String DATABASE_VERSION="1";
    public static final String DATABASE_NAME="Kusuma.db";
    public static final String TABLE_NAME="kusuma_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="NUMBER";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="create table kusuma_table(ID INTEGER PRIMARY KEY NOT NULL AUTOINCREAMENT,"+"NAME TEXT NOT NULL,,NUMBER INTEGER NOT NULL); ";

    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }
    public void insertContact(Contact c)
    {
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        String query="select * from kusuma_table";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();
        values.put(COL_1,count);
        values.put(COL_2,c.getNAME());
        values.put(COL_3,c.getNUMBER());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);


    }
    public void onDelete(String COL_2,SQLiteDatabase sqLiteDatabase){
        String selection= COL_2 +"LIKE ?";
        String[] selection_args={COL_2};
        sqLiteDatabase.delete(COL_2,selection,selection_args);
    }
}
