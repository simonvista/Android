package com.DanielMalone.inventorymanagement

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_product.*

class AddProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_product)
        btnSubmit.setOnClickListener {
            val database = getSharedPreferences("database", Context.MODE_PRIVATE)
            database.edit().apply {
                putString("savedProductName", etProductName.text.toString())
            }.apply()
        }

    }
}