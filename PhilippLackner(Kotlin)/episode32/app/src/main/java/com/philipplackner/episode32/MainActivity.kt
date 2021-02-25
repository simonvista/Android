package com.philipplackner.episode32

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var receiver:AirplaneModeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver=AirplaneModeChangeReceiver()
//        IntentFilter is dynamic receiver
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(
                receiver,it
            )
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}
