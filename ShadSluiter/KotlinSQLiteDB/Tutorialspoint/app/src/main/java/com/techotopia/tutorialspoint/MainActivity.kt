package com.techotopia.tutorialspoint

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper=DBHelper(this)
        btnAddOne.setOnClickListener {
            val name=etName.text.toString()
            val age=etAge.text.toString()
            if (name.isNotEmpty() && age.isNotEmpty()){
                val user=User(name,age.toInt())
                dbHelper.addOne(user)
//                clear()
            }else{
                Toast.makeText(this,"Input can't be blank!",Toast.LENGTH_LONG).show()
            }
            clear()
        }
        btnReadAll.setOnClickListener {
            val users=dbHelper.readAll()
            tvUserList.text=""
            users.map {
                tvUserList.append(it.toString()+"\n")
            }
        }
        btnDeleteOne.setOnClickListener {
            val res=dbHelper.deleteOne(etName.text.toString())
            if (res){
                Toast.makeText(this,"Done with deletion!",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Wrong username!",Toast.LENGTH_LONG).show()
            }
            clear()
        }
    }
    private fun clear(): Unit {
        etName.text.clear()
        etAge.text.clear()
    }
}
