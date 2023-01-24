package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button btnlogin;
    private Button btnsinup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.etusername);
        password = (EditText) findViewById(R.id.etpassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnsinup = (Button) findViewById(R.id.btnsinup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(username.getText().toString(), password.getText().toString());
                username.setText("");
                password.setText("");
            }
        });

        btnsinup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    startActivity(new Intent(MainActivity.this, ThiredActivity.class));
                }
            });

    }
    private void validate(String etusername, String etpassword ){
        if((etusername.equals("Admin")) && (etpassword.equals("Admin"))){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
    }

}