package com.philipplackner.episode12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOrder.setOnClickListener {
            val checkedMeatRadioButtonId=rgMeat.checkedRadioButtonId
            val meat=findViewById<RadioButton>(checkedMeatRadioButtonId)
            val cheese=cbCheese.isChecked
            val onion=cbOnion.isChecked
            val salad=cbSalad.isChecked
            val summary="You ordered a berger with:\n"+
                    "${meat.text}"+
                    (if(cheese) "\nCheese" else "")+
                    (if(onion) "\nOnion" else "")+
                    (if(salad) "\nSalad" else "")
            tvSummary.text=summary
        }
    }
}
