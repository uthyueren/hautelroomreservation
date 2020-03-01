package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Checkout extends AppCompatActivity {

    TextView checkin, checkout, daynight, totalprice;
    Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkin = (TextView)findViewById(R.id.checkin);
        checkout = (TextView)findViewById(R.id.checkout);
        daynight = (TextView)findViewById(R.id.tvDayNight);
        totalprice = (TextView)findViewById(R.id.tvTotalPrice);
        btnCheckout = (Button) findViewById(R.id.btnCheckout);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Checkout.this, Receipt.class));
            }
        });
    }
}
