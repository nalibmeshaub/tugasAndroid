package com.example.uts;

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

        Button orderList = (Button)findViewById(R.id.orderBtn);
        orderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOrder = new Intent(getApplicationContext(), MyOrder.class);
                startActivity(startOrder);
            }
        });
        Button drinkList = (Button)findViewById(R.id.drinkBtn);
        drinkList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDrink = new Intent(getApplicationContext(), Drink.class);
                startActivity(startDrink);
            }
        });
        Button foodList = (Button)findViewById(R.id.foodBtn);
        foodList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startFood = new Intent(getApplicationContext(), Food.class);
                startActivity(startFood);
            }
        });
        Button snackList = (Button)findViewById(R.id.snackBtn);
        snackList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSnack = new Intent(getApplicationContext(), Snack.class);
                startActivity(startSnack);
            }
        });
        Button topUp = (Button)findViewById(R.id.topupBtn);
        topUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startTop = new Intent(getApplicationContext(), TopUp.class);
                startActivity(startTop);
            }
        });
    }
}