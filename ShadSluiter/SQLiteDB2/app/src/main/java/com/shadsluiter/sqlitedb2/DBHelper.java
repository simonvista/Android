package com.shadsluiter.sqlitedb2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IS_ACTIVE = "isActive";

    public DBHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery= "create table " + CUSTOMER_TABLE + " (" +
                COLUMN_ID + " integer primary key autoincrement, " + COLUMN_NAME + " text, " + COLUMN_AGE + " int, " + COLUMN_IS_ACTIVE + " bool)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addOne(CustomerModel cm){
        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues store data in pairs.E.g. cv.put("name",name);cv.getString("name");
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,cm.getName());
        cv.put(COLUMN_AGE,cm.getAge());
        cv.put(COLUMN_IS_ACTIVE,cm.isActive());
        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if(insert==-1){
            return false;
        }
        return  true;
    }
}
