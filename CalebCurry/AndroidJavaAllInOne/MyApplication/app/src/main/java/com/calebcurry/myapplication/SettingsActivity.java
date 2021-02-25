package com.calebcurry.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
//        Retrieve data from MainActivity
        Intent i=getIntent();
        String msg=i.getStringExtra("Msg");
        TextView tv=findViewById(R.id.textView);
        tv.setText(msg);
    }
}
