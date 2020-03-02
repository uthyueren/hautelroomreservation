package com.example.loginproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.lang.reflect.Member;

public class CalendarDate extends AppCompatActivity {

    private TextView CID, COD;
    private ImageView back;
    private Button saveDateCID, saveDateCOD, confirm;
    private Dialog popupCID, popupCOD;
    private DatabaseReference databaseReference;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_date);

        popupCID = new Dialog(this);
        popupCOD = new Dialog(this);
        back = (ImageView)findViewById(R.id.backDate);
        CID = (TextView)findViewById(R.id.tvCID);
        COD = (TextView)findViewById(R.id.tvCOD);
        confirm = (Button)findViewById(R.id.btnConfirm);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarDate.this, RoomOption.class));
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
        TextView close, cid;
        CalendarView calendarViewCID;

        popupCID.setContentView(R.layout.checkindate);
        close = (TextView)popupCID.findViewById(R.id.closeCID);
        cid = (TextView)popupCID.findViewById(R.id.tvTitle1) ;
        saveDateCID = (Button)findViewById(R.id.btnSaveDateCID);
        calendarViewCID = (CalendarView)popupCID.findViewById(R.id.calendarViewCID);

        calendarViewCID.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dateCID = (dayOfMonth + 1) + "/" + month + "/" + year;
            }
        });

        saveDateCID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupCID.dismiss();;
            }
        });
        popupCID.show();
    }

    public void showPopupCOD(View v){
        TextView close, cod;
        CalendarView calendarViewCOD;

        popupCOD.setContentView(R.layout.checkoutdate);
        close = (TextView)popupCOD.findViewById(R.id.closeCOD);
        cod = (TextView)popupCOD.findViewById(R.id.tvTitle2);
        saveDateCOD = (Button)findViewById(R.id.btnSaveDateCOD);
        calendarViewCOD = (CalendarView)popupCOD.findViewById(R.id.calendarViewCOD);

        calendarViewCOD.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dateCOD = (dayOfMonth + 1) + "/" + month + "/" + year;
            }
        });

        saveDateCOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupCOD.dismiss();;
            }
        });
        popupCOD.show();
    }
}
