package com.philipplackner.episode14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOpenActivity.setOnClickListener {
//            Intent is a java class and expects an Android Context and a Java Class (The activity) as the arguments.
            Intent(this,SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
