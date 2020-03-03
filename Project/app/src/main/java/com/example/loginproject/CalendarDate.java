package com.example.loginproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CalendarDate extends AppCompatActivity {

    private TextView CID, COD, title;
    private ImageView back, popcid, popcod;
    private Button confirm;
    private Dialog popupCID, popupCOD;
    private DatabaseReference databaseReference;
    CalendarView calendarViewCID, calendarViewCOD;
    BookingDate bookingDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_date);

        popupCID = new Dialog(this);
        popupCOD = new Dialog(this);
        back = (ImageView)findViewById(R.id.backDate);
        CID = (TextView)findViewById(R.id.tvCID);
        COD = (TextView)findViewById(R.id.tvCOD);
        popcid = (ImageView)findViewById(R.id.popupCID);
        popcod = (ImageView)findViewById(R.id.popupCOD);
        confirm = (Button)findViewById(R.id.btnConfirm);
        bookingDate = new BookingDate();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("BookingDate");

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarDate.this, RoomOption.class));
                bookingDate.setCheckoutdate(COD.getText().toString());
                databaseReference.push().setValue(bookingDate);
                Toast.makeText(CalendarDate.this, "Sent to database", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarDate.this, SecondActivity.class));
            }
        });
    }

    public void showPopupCID(View v){
        Button saveCID;

        popupCID.setContentView(R.layout.checkindate_popup);
        saveCID = (Button)popupCID.findViewById(R.id.saveCID);
        title = (TextView)popupCID.findViewById(R.id.tvTitle1);
        calendarViewCID = (CalendarView)popupCID.findViewById(R.id.calendarViewCID);

        calendarViewCID.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dateCID = (dayOfMonth + 1) + "/" + month + "/" + year;
                title.setText(dateCID);
                bookingDate.setCheckindate(dateCID);
                databaseReference.push().setValue(bookingDate);
                Toast.makeText(CalendarDate.this, "Sent to database", Toast.LENGTH_SHORT).show();
            }
        });

        saveCID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupCID.dismiss();
            }
        });
        popupCID.show();
    }

    public void showPopupCOD(View v){
        Button saveCOD;

        popupCOD.setContentView(R.layout.checkoutdate_popup);
        saveCOD = (Button)popupCOD.findViewById(R.id.saveCOD);
        title = (TextView)popupCOD.findViewById(R.id.tvTitle2);
        calendarViewCOD = (CalendarView)popupCOD.findViewById(R.id.calendarViewCOD);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.checkindate_popup, (ViewGroup)findViewById(R.id.layoutCOD));

        calendarViewCOD.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dateCOD = (dayOfMonth + 1) + "/" + month + "/" + year;
                title.setText(dateCOD);
                COD.setText(dateCOD);

            }
        });

        saveCOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupCOD.dismiss();
            }
        });
        popupCOD.show();
    }
}