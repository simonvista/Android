package com.philipplackner.episode14

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btnGoBack.setOnClickListener {
//            Kill current activity from stack
            finish()
            /*Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }*/
        }
        btnThirdActivity.setOnClickListener {
            Intent(this,ThirdActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}