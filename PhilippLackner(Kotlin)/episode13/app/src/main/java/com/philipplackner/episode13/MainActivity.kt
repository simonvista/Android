package com.philipplackner.episode13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShowToast.setOnClickListener {
//            Custom toast
            Toast(this).apply {
                duration=Toast.LENGTH_LONG
                view=layoutInflater.inflate(R.layout.custom_toast,clToast)
                show()
            }
//            2 ways to use toast provided by android
//            Toast.makeText(applicationContext,"Hello applicationcontext toast",Toast.LENGTH_LONG).show()
//            Toast.makeText(this,"Hi, I'm a toast",Toast.LENGTH_LONG).show()
        }
    }
}
