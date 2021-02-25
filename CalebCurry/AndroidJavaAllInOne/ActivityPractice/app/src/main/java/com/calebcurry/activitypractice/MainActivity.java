package com.calebcurry.activitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void postMsg(View v){
        Intent i=new Intent(this,PostMsgActivity.class);
        String s=((Button) v).getText().toString();
        i.putExtra("Name",s);
        startActivity(i);

    }
}

