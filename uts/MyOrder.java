package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyOrder extends AppCompatActivity {
//    String s1[], s2[];
//    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

//        s1 = getResources().getStringArray(R.array.naming);
//        s1 = getResources().getStringArray(R.array.quants);
//        rv = findViewById(R.id.recyclerView);
//        YourAdapter yourAdapter = new YourAdapter(this, s1, s2);
//        rv.setAdapter(yourAdapter);
//        rv.setLayoutManager(new LinearLayoutManager(this));

        int costName = 0, numName = 0;
        String nameName = "";
        if(getIntent().hasExtra("com.example.uts.item")) {
            TextView name = (TextView)findViewById(R.id.itemName);
            String text = getIntent().getExtras().getString("com.example.uts.item");
            name.setText(text);
            nameName = text;
        }
        if(getIntent().hasExtra("com.example.uts.many")
                && getIntent().hasExtra("com.example.uts.pricing")) {
            TextView number = (TextView)findViewById(R.id.quantityView);
            int num = getIntent().getExtras().getInt("com.example.uts.many");
            int cost = getIntent().getExtras().getInt("com.example.uts.pricing");
            number.setText(num + " x Rp. " + cost);
            costName = cost;
            numName = num;
        }
        final int totals = costName * numName;
        final String totalInString = Integer.toString(totals);
        final TextView total = (TextView)findViewById(R.id.totalView);
        total.setText("Total: Rp. " + totals);

        Button done = (Button)findViewById(R.id.payBtn);
        final int finalCostName = costName;
        final int finalNumName = numName;
        final String finalNameName = nameName;
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDone = new Intent(getApplicationContext(), Payment.class);
                startDone.putExtra("com.example.uts.total", totalInString);
                startDone.putExtra("com.example.uts.many", finalNumName);
                startDone.putExtra("com.example.uts.item", finalNameName);
                startDone.putExtra("com.example.uts.pricing", finalCostName);
                startActivity(startDone);
            }
        });
    }
}