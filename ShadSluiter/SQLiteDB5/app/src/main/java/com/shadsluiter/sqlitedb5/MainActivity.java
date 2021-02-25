package com.shadsluiter.sqlitedb5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAddOne,btnViewAll;
    EditText etName,etAge;
    Switch swActiveCustomer;
    ListView lvCustomerList;

    ArrayAdapter customerArrayAdapter;
    DBHelper dbHelper;

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

        dbHelper=new DBHelper(MainActivity.this);
        showCustomersOnListview(dbHelper);

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
                showCustomersOnListview(dbHelper);
//                Toast.makeText(MainActivity.this,"Button addOne is clicked",Toast.LENGTH_LONG).show();
            }
        });
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper=new DBHelper(MainActivity.this);
//                List<CustomerModel> allCustomers = dbHelper.getAll();
//                Toast.makeText(MainActivity.this,allCustomers.toString(),Toast.LENGTH_LONG).show();
//                Create ArrayAdapter
                showCustomersOnListview(dbHelper);
            }
        });
        lvCustomerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomerModel clickedCustomer= (CustomerModel) parent.getItemAtPosition(position);
                dbHelper.deleteOne(clickedCustomer);
                showCustomersOnListview(dbHelper);
                Toast.makeText(MainActivity.this,"Deleted successfully",Toast.LENGTH_LONG).show();

            }
        });

    }

    private void showCustomersOnListview(DBHelper dbHelper2) {
        customerArrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, dbHelper2.getAll());
        lvCustomerList.setAdapter(customerArrayAdapter);
    }

}
