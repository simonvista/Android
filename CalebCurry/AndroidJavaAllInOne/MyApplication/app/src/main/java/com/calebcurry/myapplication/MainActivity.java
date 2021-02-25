package com.calebcurry.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
//        Log.d("onCreate","onCreate was called");
    }
    public void launchSettings(View v){
//        Launch a new activity
        Intent i=new Intent(this,SettingsActivity.class);
//        Send data to SettingsActivity
        TextView tv=findViewById(R.id.source);
        String msg=tv.getText().toString();
        i.putExtra("Msg",msg);
//        i.putExtra("Msg","Hello!");
        startActivity(i);
    }

    public void handleText(View v){
        EditText et=findViewById(R.id.source);
        String input= et.getText().toString();
        TextView tv=findViewById(R.id.hello);
        tv.setText(input);
        Toast.makeText(this,input,Toast.LENGTH_LONG).show();
//        Log.d("text_field",s);
    }

    public void disable(View v){
        Button b=findViewById(R.id.button);
        b.setText("Button Disabled!");
        b.setEnabled(false);
        TextView tv=findViewById(R.id.hello);
        tv.setText("Button Clicked!");

        /*((Button)findViewById(R.id.button)).setText("Button disabled!");
        findViewById(R.id.button).setEnabled(false);
        ((TextView)findViewById(R.id.hello)).setText("Button clicked!");*/

        /*v.setEnabled(false);
        Button b=(Button) v;
        b.setText("Disabled");*/
//        Log.d("success","Button disabled");
    }
}
