package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Oil extends AppCompatActivity {
    //ArrayList items, prices, quantities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil);

        String foodName = "";
        Integer priceName = 0;
        if(getIntent().hasExtra("com.example.uts.name")) {
            TextView name = (TextView)findViewById(R.id.drinkName);
            String text = getIntent().getExtras().getString("com.example.uts.name");
            name.setText(text);
            foodName = text;
            //items.add(text);
        }
        if(getIntent().hasExtra("com.example.uts.price")) {
            TextView number = (TextView)findViewById(R.id.priceView);
            Integer text1 = getIntent().getExtras().getInt("com.example.uts.price");
            number.setText("Rp. " + text1);
            priceName = text1;
            //prices.add(text1);
        }

        final String finalFoodName = foodName;
        final Integer finalPriceName = priceName;
        Button orderList = (Button)findViewById(R.id.orderBtn);
        orderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOrder = new Intent(getApplicationContext(), MyOrder.class);
                EditText getQuantity = (EditText)findViewById(R.id.numText);
                int num = Integer.parseInt(getQuantity.getText().toString());
                startOrder.putExtra("com.example.uts.many", num);
                startOrder.putExtra("com.example.uts.item", finalFoodName);
                startOrder.putExtra("com.example.uts.pricing", finalPriceName);
                //quantities.add(num);
                startActivity(startOrder);
            }
        });
        Button backList = (Button)findViewById(R.id.backBtn);
        backList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moreOrder = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(moreOrder);
                // quantities.add(1);
            }
        });
    }
}