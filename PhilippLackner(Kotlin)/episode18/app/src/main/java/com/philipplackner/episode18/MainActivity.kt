package com.philipplackner.episode18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContact-> Toast.makeText(this,"You chose AddContact",Toast.LENGTH_SHORT).show()
            R.id.miFeedback-> Toast.makeText(this,"You chose Feedback",Toast.LENGTH_SHORT).show()
            R.id.miCloseApp-> finish()
            R.id.miFavorite-> Toast.makeText(this,"You chose Favorite",Toast.LENGTH_SHORT).show()
            R.id.miSetting-> Toast.makeText(this,"You chose Setting",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
