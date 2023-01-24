package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Form extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText NameEdt, EmailEdt, PhoneEdt, AddressEdt;
    private Button  SubmitBtn;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // initializing all our variables.
        NameEdt = findViewById(R.id.etusername1);
        EmailEdt = findViewById(R.id.etemail);
        PhoneEdt = findViewById(R.id.etphone);
        AddressEdt = findViewById(R.id.etaddress);
        SubmitBtn = findViewById(R.id.btnlogin2);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHelper = new DBHelper(Form.this);

        // below line is to add on click listener for our add course button.
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String Name = NameEdt.getText().toString();
                String Email = EmailEdt.getText().toString();
                String Phone = PhoneEdt.getText().toString();
                String Address = AddressEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (Name.isEmpty() && Email.isEmpty() && Phone.isEmpty() && Address.isEmpty()) {
                    Toast.makeText(Form.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHelper.addNewCourse(Name, Email, Phone, Address);

                // after adding the data we are displaying a toast message.
                Toast.makeText(Form.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                NameEdt.setText("");
                EmailEdt.setText("");
                PhoneEdt.setText("");
                AddressEdt.setText("");
            }
        });
    }
}