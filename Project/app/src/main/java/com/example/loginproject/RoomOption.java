package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class RoomOption extends AppCompatActivity {

    private ImageView back;
    private Dialog popup;
    private ElegantNumberButton numberButton;
    private Button confirm;
    String count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_option);


        back = (ImageView)findViewById(R.id.backRoom);
        confirm = (Button)findViewById(R.id.btnConfirm);
        numberButton = (ElegantNumberButton)findViewById(R.id.num1);
        popup = new Dialog(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomOption.this, CalendarDate.class));
            }
        });

        numberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                count = numberButton.getNumber();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count != "0") {
                    startActivity(new Intent(RoomOption.this, Checkout.class));
                } else {
                    Toast.makeText(RoomOption.this, "Please add room", Toast.LENGTH_SHORT).show();
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

        popup.setContentView(R.layout.cv_famquad_room);
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
