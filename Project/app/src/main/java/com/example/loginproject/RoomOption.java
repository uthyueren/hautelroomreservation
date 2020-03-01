package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RoomOption extends AppCompatActivity {

    private ImageView back;
    private Dialog popup;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_option);

        back = (ImageView)findViewById(R.id.backRoom);
        popup = new Dialog(this);
        info = (TextView)findViewById(R.id.info);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomOption.this, CalendarDate.class));
            }
        });
    }

    public void showPopup(View v){
        TextView close;

        popup.setContentView(R.layout.info_popup);
        close = (TextView)popup.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        popup.show();
    }
}
