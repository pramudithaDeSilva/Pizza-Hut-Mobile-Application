package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThiredActivity extends AppCompatActivity {

    private Button btnsinup2;
    private Button btnlogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thired);

        btnsinup2 = (Button) findViewById(R.id.btnsinup2);
        btnlogin2 = (Button) findViewById(R.id.btnlogin2);



        btnsinup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                startActivity(new Intent(ThiredActivity.this, ThiredActivity.class));
            }
        });

        btnlogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                startActivity(new Intent(ThiredActivity.this, MainActivity.class));
            }
        });

    }
}