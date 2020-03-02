package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Checkout extends AppCompatActivity {

    TextView checkIn, checkOut, dayNight, totalPrice;
    Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkIn = (TextView)findViewById(R.id.checkin);
        checkOut = (TextView)findViewById(R.id.checkout);
        dayNight = (TextView)findViewById(R.id.tvDayNight);
        totalPrice = (TextView)findViewById(R.id.tvTotalPrice);
        btnCheckout = (Button) findViewById(R.id.btnCheckout);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Checkout.this, Receipt.class));
            }
        });
    }
}
