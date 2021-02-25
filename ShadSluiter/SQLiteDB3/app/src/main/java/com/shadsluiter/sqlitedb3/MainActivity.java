package com.shadsluiter.sqlitedb3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAddOne,btnViewAll;
    EditText etName,etAge;
    Switch swActiveCustomer;
    ListView lvCustomerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddOne=findViewById(R.id.btnAddOne);
        btnViewAll=findViewById(R.id.btnViewAll);
        etName=findViewById(R.id.etName);
        etAge=findViewById(R.id.etAge);
        swActiveCustomer=findViewById(R.id.switActiveCustomer);
        lvCustomerList=findViewById(R.id.lvCustomerList);
        btnAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerModel cm;
                try{
                    cm=new CustomerModel(
                        -1,
                        etName.getText().toString(),
                        Integer.parseInt(etAge.getText().toString()),
                        swActiveCustomer.isChecked());
                    Toast.makeText(MainActivity.this,cm.toString(),Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input",Toast.LENGTH_LONG).show();
                    cm=new CustomerModel(-1,"error",0,false);
                }
                DBHelper dbHelper=new DBHelper(MainActivity.this);
                boolean resBool=dbHelper.addOne(cm);
                Toast.makeText(MainActivity.this,"Add result: "+resBool,Toast.LENGTH_LONG).show();
//                Toast.makeText(MainActivity.this,"Button addOne is clicked",Toast.LENGTH_LONG).show();
            }
        });
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper=new DBHelper(MainActivity.this);
                List<CustomerModel> allCustomers = dbHelper.getAll();
                Toast.makeText(MainActivity.this,allCustomers.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }

}
