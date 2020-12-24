package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Snack extends AppCompatActivity {
    public static final String name = "com.example.uts.name";
    public static final String price = "com.example.uts.price";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        Button orderList = (Button)findViewById(R.id.orderBtn);
        orderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOrder = new Intent(getApplicationContext(), MyOrder.class);
                startActivity(startOrder);
            }
        });
        Button linuxNum = (Button)findViewById(R.id.linuxBtn);
        linuxNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addLinux = new Intent(getApplicationContext(), Oil.class);
                addLinux.putExtra(name, "Linux");
                addLinux.putExtra(price, 950);
                startActivity(addLinux);
            }
        });
        Button meatNum = (Button)findViewById(R.id.meatBtn);
        meatNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMeat = new Intent(getApplicationContext(), Oil.class);
                addMeat.putExtra(name, "Meat");
                addMeat.putExtra(price, 2800);
                startActivity(addMeat);
            }
        });
        Button chikiNum = (Button)findViewById(R.id.chikiBtn);
        chikiNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addChiki = new Intent(getApplicationContext(), Oil.class);
                addChiki.putExtra(name, "Chiki");
                addChiki.putExtra(price, 420);
                startActivity(addChiki);
            }
        });
        Button sanofiNum = (Button)findViewById(R.id.sanofiBtn);
        sanofiNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSanofi = new Intent(getApplicationContext(), Oil.class);
                addSanofi.putExtra(name, "Sanofi");
                addSanofi.putExtra(price, 4150);
                startActivity(addSanofi);
            }
        });
    }
}