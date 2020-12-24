package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Drink extends AppCompatActivity {
    public static final String name = "com.example.uts.quantity";
    public static final String price = "com.example.uts.price";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        Button orderList = (Button)findViewById(R.id.orderBtn);
        orderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOrder = new Intent(getApplicationContext(), MyOrder.class);
                startActivity(startOrder);
            }
        });
        Button rinsoNum = (Button)findViewById(R.id.rinsoBtn);
        rinsoNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addRinso = new Intent(getApplicationContext(), Oil.class);
                addRinso.putExtra(name, "Rinso");
                addRinso.putExtra(price, 1000);
                startActivity(addRinso);
            }
        });
        Button vinegarNum = (Button)findViewById(R.id.vinegarBtn);
        vinegarNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addVinegar = new Intent(getApplicationContext(), Oil.class);
                addVinegar.putExtra(name, "Vinegar");
                addVinegar.putExtra(price, 1500);
                startActivity(addVinegar);
            }
        });
        Button mineralNum = (Button)findViewById(R.id.mineralBtn);
        mineralNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMineral = new Intent(getApplicationContext(), Oil.class);
                addMineral.putExtra(name, "Mineral");
                addMineral.putExtra(price, 500);
                startActivity(addMineral);
            }
        });
        Button mercuryNum = (Button)findViewById(R.id.mercuryBtn);
        mercuryNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMercury = new Intent(getApplicationContext(), Oil.class);
                addMercury.putExtra(name, "Mercury");
                addMercury.putExtra(price, 4000);
                startActivity(addMercury);
            }
        });
    }
}