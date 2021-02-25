package com.shadsluiter.sqlitedb4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    public List<CustomerModel> getAll(){
        List<CustomerModel> returnList=new ArrayList<>();
        String queryString="select * from "+CUSTOMER_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()) {
            do{
                int id=cursor.getInt(0);
                String name=cursor.getString(1);
                int age=cursor.getInt(2);
                boolean isActive=cursor.getInt(3)==1 ? true:false;
                CustomerModel cm=new CustomerModel(id,name,age,isActive);
                returnList.add(cm);
            }while (cursor.moveToNext());
        }else{

        }
//        Never forget to close both cursor and db when done
        cursor.close();
        db.close();
        return returnList;
    }
}
