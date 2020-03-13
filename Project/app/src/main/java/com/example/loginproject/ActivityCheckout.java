package com.example.loginproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityCheckout extends AppCompatActivity {

    private TextView checkIn, checkOut, roomNum, totalPrice, singleQ, twinQ, triQ, quadQ;
    private FloatingActionButton btnConfirm;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkIn = findViewById(R.id.checkin);
        checkOut = findViewById(R.id.checkout);
        roomNum = findViewById(R.id.checkoutRoomNumber);
        totalPrice = findViewById(R.id.tvTotalPrice);
        singleQ = findViewById(R.id.singleQ);
        twinQ = findViewById(R.id.twinQ);
        triQ = findViewById(R.id.triQ);
        quadQ = findViewById(R.id.quadQ);
        btnConfirm = findViewById(R.id.btnConfirm);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("ClassBooking").child("booking1");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String checkin = dataSnapshot.child("checkindate").getValue().toString();
                checkIn.setText(checkin);
                String checkout = dataSnapshot.child("checkoutdate").getValue().toString();
                checkOut.setText(checkout);
                String Q1 = "Quantity: " + Integer.valueOf(dataSnapshot.child("singleRoom").getValue().toString());
                singleQ.setText(Q1);
                String Q2 = "Quantity: " + Integer.valueOf(dataSnapshot.child("twinRoom").getValue().toString());
                twinQ.setText(Q2);
                String Q3 = "Quantity: " + Integer.valueOf(dataSnapshot.child("triRoom").getValue().toString());
                triQ.setText(Q3);
                String Q4 = "Quantity: " + Integer.valueOf(dataSnapshot.child("quadRoom").getValue().toString());
                quadQ.setText(Q4);
                String room = dataSnapshot.child("bookingNum").getValue().toString();
                roomNum.setText(room);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ActivityCheckout.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });



        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityCheckout.this, ActivityReceipt.class));
            }
        });
    }
}
