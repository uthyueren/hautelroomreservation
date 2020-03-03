package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityCheckout extends AppCompatActivity {

    private TextView checkIn, checkOut, dayNight, totalPrice;
    private Button btnCheckout;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    ClassBooking classBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkIn = (TextView)findViewById(R.id.checkin);
        checkOut = (TextView)findViewById(R.id.checkout);
        dayNight = (TextView)findViewById(R.id.tvDayNight);
        totalPrice = (TextView)findViewById(R.id.tvTotalPrice);
        btnCheckout = (Button) findViewById(R.id.btnCheckout);
        classBooking = new ClassBooking();

//        firebaseAuth = FirebaseAuth.getInstance();
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference = firebaseDatabase.getReference().child("BookingDatabase");

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityCheckout.this, ActivityReceipt.class));
            }
        });

//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String checkin = dataSnapshot.child("checkindate").getValue().toString();
//                String checkout = dataSnapshot.child("checkoutdate").getValue().toString();
//                checkIn.setText(checkin);
//                checkOut.setText(checkout);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }
}
