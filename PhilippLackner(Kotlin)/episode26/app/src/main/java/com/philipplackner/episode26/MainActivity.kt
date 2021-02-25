package com.philipplackner.episode26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    lateinit means late initialize
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Initialize
        toggle= ActionBarDrawerToggle(
            this,drawerLayout,R.string.open,R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1->Toast.makeText(applicationContext,"You clicked Item1",Toast.LENGTH_SHORT).show()
                R.id.miItem2->Toast.makeText(applicationContext,"You clicked Item2",Toast.LENGTH_SHORT).show()
                R.id.miItem3->Toast.makeText(applicationContext,"You clicked Item3",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}
