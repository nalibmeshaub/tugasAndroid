package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button back = (Button)findViewById(R.id.mainBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOrder = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startOrder);
            }
        });
        if(getIntent().hasExtra("com.example.uts.item")) {
            TextView name = (TextView)findViewById(R.id.itemName);
            String text = getIntent().getExtras().getString("com.example.uts.item");
            name.setText(text);
        }
        if(getIntent().hasExtra("com.example.uts.many")
                && getIntent().hasExtra("com.example.uts.pricing")) {
            TextView number = (TextView)findViewById(R.id.quantityView);
            int num = getIntent().getExtras().getInt("com.example.uts.many");
            int cost = getIntent().getExtras().getInt("com.example.uts.pricing");
            number.setText(num + " x Rp. " + cost);
        }
        TextView totals = (TextView)findViewById(R.id.totalView);
        String tot = getIntent().getExtras().getString("com.example.uts.total");
        totals.setText("Total: Rp. " + tot);
    }
}