package eu.tutorials.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Button click listener
        // get reference to button
//        val btnClickMe = findViewById(R.id.button) as Button
//        val myTextView=findViewById(R.id.textView) as TextView
        var timeClicked=0
        // set on-click listener
        button.setOnClickListener {
            timeClicked++
            textView.text="You clicked $timeClicked times"
//            myTextView.text="Test"
            Toast.makeText(this@MainActivity, "Hi, You just clicked me.", Toast.LENGTH_SHORT).show()
        }
        /*btnClickMe.setOnClickListener {
            timeClicked++
            myTextView.text="You clicked $timeClicked times"
//            myTextView.text="Test"
            Toast.makeText(this@MainActivity, "Hi, You just clicked me.", Toast.LENGTH_SHORT).show()
        }*/
    }
}
