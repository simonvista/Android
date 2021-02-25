package com.calebcurry.activitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class PostMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_msg);
        Intent i=getIntent();
        String s=i.getStringExtra("Name");
        EditText et=findViewById(R.id.editText);
        if(s==null){
            et.setText("No name found!");
        }else{
            et.setText(s);
        }
//        Log.d("NamE",s);

    }
}
