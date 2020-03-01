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

public class CalendarDate extends AppCompatActivity {

    private TextView CID, COD, closeCID, closeCOD;
    private ImageView back;
    private CalendarView calendarViewCID, calendarViewCOD;
    private Button saveDateCID, saveDateCOD, confirm;
    private Dialog popupCID, popupCOD;

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
        TextView close;

        popupCID.setContentView(R.layout.checkindate);
        close = (TextView)popupCID.findViewById(R.id.closeCID);
        saveDateCID = (Button)findViewById(R.id.btnSaveDateCID);
        calendarViewCID = (CalendarView)findViewById(R.id.calendarViewCID);

        calendarViewCID.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                final String dateCID = (dayOfMonth + 1) + "/" + month + "/" + year;
                saveDateCID.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CID.setText(dateCID);
                    }
                });
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
        TextView close;

        popupCOD.setContentView(R.layout.checkoutdate);
        close = (TextView)popupCOD.findViewById(R.id.closeCOD);
        saveDateCOD = (Button)findViewById(R.id.btnSaveDateCOD);
        calendarViewCOD = (CalendarView)findViewById(R.id.calendarViewCOD);

        calendarViewCOD.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                final String dateCOD = (dayOfMonth + 1) + "/" + month + "/" + year;
                saveDateCOD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        COD.setText(dateCOD);
                    }
                });
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
