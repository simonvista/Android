package com.philipplackner.episode9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var cnt=0
        btnCount.setOnClickListener {
            cnt++
            tvCount.text="Let's count together: $cnt"
        }
    }
}
