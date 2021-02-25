package com.philipplackner.episode19

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        ContactDialog triggered by btnDialog1
        val addContactDialog=AlertDialog.Builder(this).setTitle("Add contact")
                                                                .setMessage("Do you want to add Mr. Dane to your contact list?")
                                                                .setIcon(R.drawable.ic_add_contact)
                                                                .setPositiveButton("Yes"){
                                                                    _, _ ->Toast.makeText(this,"You added Mr. Dane to your contact list",Toast.LENGTH_SHORT).show()
                                                                }
                                                                .setNegativeButton("No"){
                                                                    _, _ ->Toast.makeText(this,"You rejected Mr Dane as your contact",Toast.LENGTH_SHORT).show()
                                                                }.create()
        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }
//        SingleChoiceDialog triggered by btnDialog2
        val options= arrayOf("First Item","Second Item","Third Item")
        val singleChoiceDialog=AlertDialog.Builder(this).setTitle("Choose one of these options")
                                                                .setSingleChoiceItems(options,0){
                                                                    _, i -> Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
                                                                }.setPositiveButton("Accept"){
                                                                        _, _ ->Toast.makeText(this,"You accepted the SinglechoiceDialog",Toast.LENGTH_SHORT).show()
                                                                }
                                                                .setNegativeButton("Decline"){
                                                                        _, _ ->Toast.makeText(this,"You declined the SinglechoiceDialog",Toast.LENGTH_SHORT).show()
                                                                }.create()
        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }
//        MultichoiceDialog triggered by btnDialog3
        val multiChoiceDialog=AlertDialog.Builder(this).setTitle("Choose one of these options")
                                                                .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){
                                                                    _, i, b ->if(b){
                                                                        Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
                                                                    }else{
                                                                        Toast.makeText(this, "You unclicked on ${options[i]}", Toast.LENGTH_SHORT).show()
                                                                    }
                                                                }.setPositiveButton("Accept"){
                                                                        _, _ ->Toast.makeText(this,"You accepted the MultichoiceDialog",Toast.LENGTH_SHORT).show()
                                                                }
                                                                .setNegativeButton("Decline"){
                                                                        _, _ ->Toast.makeText(this,"You declined the MultichoiceDialog",Toast.LENGTH_SHORT).show()
                                                                }.create()
        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }

}
