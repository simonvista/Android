package com.philipplackner.episode27

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Shared preferences only works for small data
        val sharedPref=getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor=sharedPref.edit()
        btnSave.setOnClickListener {
//          get values from inputs and checkbox
            val name=etName.text.toString()
            val age=etAge.text.toString().toInt()
            val isAdult=cbAdult.isChecked
            editor.apply {
                putString("name",name)
                putInt("age",age)
                putBoolean("isAdult",isAdult)
//                apply() is async. commit() is sync
                apply()
            }
        }
        btnLoad.setOnClickListener {
//            2nd parameter is default value if no 1st parameter(key) is provided
            val name=sharedPref.getString("name",null)
            val age=sharedPref.getInt("age",0)
            val isAdult=sharedPref.getBoolean("isAdult",false)
            etName.setText(name)
            etAge.setText(age.toString())
            cbAdult.isChecked=isAdult
        }
    }
}
