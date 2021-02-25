package com.philipplackner.episode1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Java mode to find view by id
//        val btnApply=findViewById<Button>(R.id.btnApply)
//        Kotlin mode to find view by id
        btnApply.setOnClickListener {
            val firstName=etFirstName.text.toString()
            val lastName=etLastName.text.toString()
            val birthDay=etBirthDay.text.toString()
            val country=etCountry.text.toString()
            Log.d("Form Info","$firstName $lastName, $birthDay, $country")
        }
    }

}
