package com.philipplackner.episode15

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        /*val name=intent.getStringExtra("EXTRA_NAME")
        val age=intent.getIntExtra("EXTRA_AGE",-1)
        val country=intent.getStringExtra("EXTRA_COUNTRY")
        tvSecondActivity.text="$name, $age, $country"*/
//        Type cast
        val person=intent.getSerializableExtra("EXTRA_PERSON") as Person
        tvSecondActivity.text=person.toString()
    }
}
