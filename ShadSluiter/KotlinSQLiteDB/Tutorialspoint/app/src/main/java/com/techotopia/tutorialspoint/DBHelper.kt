package com.techotopia.tutorialspoint

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import java.util.ArrayList

class DBHelper(var context:Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery="create table $TABLE_NAME ( $COLUMN_ID integer primary key autoincrement, $COLUMN_NAME text, $COLUMN_AGE integer )"
//        val createQuery="create table "+ TABLE_NAME +"("+ COLUMN_ID+" integer primary key autoincrement,"+ COLUMN_NAME+" text,"+ COLUMN_AGE+" integer)"
        db?.execSQL(createQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, NewVersion: Int) {
        db?.execSQL("drop table if exists "+ TABLE_NAME)
        onCreate(db)
    }

    companion object{
        private val DB_NAME="ylDB.db"
        private val DB_VERSION=1
        private val TABLE_NAME="user"
        private val COLUMN_ID="id"
        private val COLUMN_NAME="name"
        private val COLUMN_AGE="age"
    }

    fun addOne(user: User): Unit {
        val db=this.writableDatabase
        val cv=ContentValues()
        cv.put(COLUMN_NAME,user.name)
        cv.put(COLUMN_AGE,user.age)
        val res=db.insert(TABLE_NAME,null,cv)
        if(res==(-1).toLong()){
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
        }
        db.close()
    }
    fun readAll(): MutableList<User> {
        val users= arrayListOf<User>()
        val readQuery="select * from "+ TABLE_NAME
        val db=this.readableDatabase
        val cursor = db.rawQuery(readQuery, null)
        if (cursor.moveToFirst()){
            do{
                val user=User()
                user.id=cursor.getString(cursor.getColumnIndex(COLUMN_ID)).toInt()
                user.name=cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                user.age=cursor.getString(cursor.getColumnIndex(COLUMN_AGE)).toInt()
                users.add(user)
            }while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return users
    }
    fun deleteOne(name: String): Boolean {
        var res=false
        val deleteQuery="select * from $TABLE_NAME where $COLUMN_NAME = \"$name\""
        Log.d("quy",deleteQuery)
        val db=this.writableDatabase
        val cursor = db.rawQuery(deleteQuery, null)
        if (cursor.moveToFirst()){
            val id=cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
            db.delete(TABLE_NAME, COLUMN_ID+"=?", arrayOf(id.toString()))
            res=true
        }
        cursor.close()
        db.close()
        return res
    }
}