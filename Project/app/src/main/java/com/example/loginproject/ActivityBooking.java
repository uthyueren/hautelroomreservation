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

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityBooking extends AppCompatActivity {

    private TextView CID, COD, title;
    private ImageView popcid, popcod;
    private FloatingActionButton confirm;
    private Dialog popupCID, popupCOD;
    private DatabaseReference databaseReference;
    private Dialog popup;
    private ElegantNumberButton numBtn1, numBtn2, numBtn3, numBtn4;
    CalendarView calendarViewCID, calendarViewCOD;
    ClassBooking classBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        confirm = (FloatingActionButton)findViewById(R.id.btnConfirm);
        numBtn1 = (ElegantNumberButton)findViewById(R.id.num1);
        numBtn2 = (ElegantNumberButton)findViewById(R.id.num2);
        numBtn3 = (ElegantNumberButton)findViewById(R.id.num3);
        numBtn4 = (ElegantNumberButton)findViewById(R.id.num4);
        classBooking = new ClassBooking();
        popup = new Dialog(this);
        popupCID = new Dialog(this);
        popupCOD = new Dialog(this);
        CID = (TextView)findViewById(R.id.tvCID);
        COD = (TextView)findViewById(R.id.tvCOD);
        popcid = (ImageView)findViewById(R.id.popupCID);
        popcod = (ImageView)findViewById(R.id.popupCOD);
        classBooking = new ClassBooking();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("ClassBooking");

        numBtn1.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                int num = Integer.parseInt(numBtn1.getNumber());
                classBooking.setSingleRoom(num);
            }
        });

        numBtn2.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                int num = Integer.parseInt(numBtn2.getNumber());
                classBooking.setTwinRoom(num);
            }
        });

        numBtn3.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                int num = Integer.parseInt(numBtn3.getNumber());
                classBooking.setTriRoom(num);
            }
        });

        numBtn4.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                int num = Integer.parseInt(numBtn4.getNumber());
                classBooking.setQuadRoom(num);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classBooking.setCheckindate(CID.getText().toString());
                classBooking.setCheckoutdate(COD.getText().toString());
                if(classBooking.getSingleRoom() != 0 || classBooking.getTwinRoom() != 0 || classBooking.getTriRoom() != 0 || classBooking.getQuadRoom() != 0){
                    databaseReference.push().setValue(classBooking);
                    Toast.makeText(ActivityBooking.this, "Sent to database", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ActivityBooking.this, ActivityCheckout.class));
                } else {
                    Toast.makeText(ActivityBooking.this, "Please add room", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showPopupCID(View v){
        Button saveCID;

        popupCID.setContentView(R.layout.popup_checkindate);
        saveCID = (Button)popupCID.findViewById(R.id.saveCID);
        title = (TextView)popupCID.findViewById(R.id.tvTitle1);
        calendarViewCID = (CalendarView)popupCID.findViewById(R.id.calendarViewCID);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup_checkindate, (ViewGroup)findViewById(R.id.layoutCID));

        calendarViewCID.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dateCID = (dayOfMonth + 1) + "/" + month + "/" + year;
                title.setText(dateCID);
                CID.setText(dateCID);
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

        popupCOD.setContentView(R.layout.popup_checkoutdate);
        saveCOD = (Button)popupCOD.findViewById(R.id.saveCOD);
        title = (TextView)popupCOD.findViewById(R.id.tvTitle2);
        calendarViewCOD = (CalendarView)popupCOD.findViewById(R.id.calendarViewCOD);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup_checkoutdate, (ViewGroup)findViewById(R.id.layoutCOD));

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

    public void showPopup(View v) {
        TextView close;

        popup.setContentView(R.layout.info_popup);
        close = popup.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        popup.show();
    }

    public void showPopupSingle(View v) {
        TextView close;

        popup.setContentView(R.layout.cv_single_room);
        close = popup.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        popup.show();
    }

    public void showPopupTwin(View v) {
        TextView close;

        popup.setContentView(R.layout.cv_twin_room);
        close = popup.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        popup.show();
    }

    public void showPopupTri(View v) {
        TextView close;

        popup.setContentView(R.layout.cv_famtri_room);
        close = popup.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        popup.show();
    }

    public void showPopupQuad(View v) {
        TextView close;

        popup.setContentView(R.layout.cv_famsuite_room);
        close = popup.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        popup.show();
    }
}