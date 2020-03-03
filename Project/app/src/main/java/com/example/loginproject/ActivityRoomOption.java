package com.example.loginproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityRoomOption extends AppCompatActivity {

    private Dialog popup;
    private ElegantNumberButton numBtn1, numBtn2, numBtn3, numBtn4;
    private Button confirm;
    private DatabaseReference databaseReference;
    ClassBooking classBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_option);
        confirm = (Button)findViewById(R.id.btnConfirm);
        numBtn1 = (ElegantNumberButton)findViewById(R.id.num1);
        numBtn2 = (ElegantNumberButton)findViewById(R.id.num2);
        numBtn3 = (ElegantNumberButton)findViewById(R.id.num3);
        numBtn4 = (ElegantNumberButton)findViewById(R.id.num4);
        classBooking = new ClassBooking();
        popup = new Dialog(this);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("BookingDatabase");

        numBtn1.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                int num = Integer.parseInt(numBtn1.getNumber());
                classBooking.setQuantity1(num);
            }
        });

        numBtn2.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                int num = Integer.parseInt(numBtn2.getNumber());
                classBooking.setQuantity2(num);
            }
        });

        numBtn3.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                int num = Integer.parseInt(numBtn3.getNumber());
                classBooking.setQuantity3(num);
            }
        });

        numBtn4.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                int num = Integer.parseInt(numBtn4.getNumber());
                classBooking.setQuantity4(num);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(classBooking.getQuantity1() != 0 || classBooking.getQuantity2() != 0 || classBooking.getQuantity3() != 0 || classBooking.getQuantity4() != 0){
                    databaseReference.push().setValue(classBooking);
                    Toast.makeText(ActivityRoomOption.this, "Sent to database", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ActivityRoomOption.this, ActivityCheckout.class));
                } else {
                    Toast.makeText(ActivityRoomOption.this, "Please add room", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
