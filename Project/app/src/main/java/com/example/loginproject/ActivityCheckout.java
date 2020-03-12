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

    private TextView checkIn, checkOut, totalRoom, totalPrice, singleQ, twinQ, triQ, quadQ;
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
        totalRoom = findViewById(R.id.tvTotalRoomNumber);
        totalPrice = findViewById(R.id.tvTotalPrice);
        singleQ = findViewById(R.id.singleQ);
        twinQ = findViewById(R.id.twinQ);
        triQ = findViewById(R.id.triQ);
        quadQ = findViewById(R.id.quadQ);
        btnConfirm = findViewById(R.id.btnConfirm);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("ClassBooking");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClassBooking classBooking = dataSnapshot.getValue(ClassBooking.class);
                checkIn.setText(classBooking.getCheckindate());
                checkOut.setText(classBooking.getCheckoutdate());
                singleQ.setText(classBooking.getSingleRoom());
                twinQ.setText(classBooking.getTwinRoom());
                triQ.setText(classBooking.getTriRoom());
                quadQ.setText(classBooking.getQuadRoom());

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
