package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Food extends AppCompatActivity {
    public static final String name = "com.example.uts.quantity";
    public static final String price = "com.example.uts.price";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Button orderList = (Button)findViewById(R.id.orderBtn);
        orderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOrder = new Intent(getApplicationContext(), MyOrder.class);
                startActivity(startOrder);
            }
        });
        Button kebabNum = (Button)findViewById(R.id.kebabBtn);
        kebabNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addKebab = new Intent(getApplicationContext(), Oil.class);
                addKebab.putExtra(name, "Kebab");
                addKebab.putExtra(price, 760);
                startActivity(addKebab);
            }
        });
        Button tanahNum = (Button)findViewById(R.id.tanahBtn);
        tanahNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTanah = new Intent(getApplicationContext(), Oil.class);
                addTanah.putExtra(name, "Tanah");
                addTanah.putExtra(price, 1200);
                startActivity(addTanah);
            }
        });
        Button rotiNum = (Button)findViewById(R.id.rotiBtn);
        rotiNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addRoti = new Intent(getApplicationContext(), Oil.class);
                addRoti.putExtra(name, "Roti");
                addRoti.putExtra(price, 340);
                startActivity(addRoti);
            }
        });
    }
}