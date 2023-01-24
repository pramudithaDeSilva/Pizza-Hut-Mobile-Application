package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity  implements View.OnClickListener{
    public CardView card1 , card2 , card3, card4, card5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
        card3 = (CardView) findViewById(R.id.card3);
        card4 = (CardView) findViewById(R.id.card4);
        card5 = (CardView) findViewById(R.id.card5);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.card1:
                i = new Intent(this,PizzaStore.class);
                startActivity(i);
                break;
            case R.id.card2:
                i = new Intent(this, Camera.class);
                startActivity(i);
                break;
            case R.id.card3:
                i = new Intent(this, Youtube.class);
                startActivity(i);
                break;
            case R.id.card4:
                i = new Intent(this, Form.class);
                startActivity(i);
                break;
            case R.id.card5:
                i = new Intent(this, LocationActivity.class);
                startActivity(i);
                break;



        }

    }
}