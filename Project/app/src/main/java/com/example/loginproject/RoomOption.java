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

public class RoomOption extends AppCompatActivity {

    private ImageView back, minus1, minus2, minus3, minus4, plus1, plus2, plus3, plus4;
    private Dialog popup;
    private TextView singleNum, twinNum, triNum, quadNum;
    private Button confirm;
    int i = 0, j = 0, k = 0, l = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_option);

        minus1 = (ImageView)findViewById(R.id.minus1);
        minus2 = (ImageView)findViewById(R.id.minus2);
        minus3 = (ImageView)findViewById(R.id.minus3);
        minus4 = (ImageView)findViewById(R.id.minus4);
        plus1 = (ImageView)findViewById(R.id.plus1);
        plus2 = (ImageView)findViewById(R.id.plus2);
        plus3 = (ImageView)findViewById(R.id.plus3);
        plus4 = (ImageView)findViewById(R.id.plus4);
        singleNum = (TextView)findViewById(R.id.tvSingleNum);
        twinNum = (TextView)findViewById(R.id.tvTwinNum);
        triNum = (TextView)findViewById(R.id.tvTriNum);
        quadNum = (TextView)findViewById(R.id.tvQuadNum);
        back = (ImageView)findViewById(R.id.backRoom);
        confirm = (Button)findViewById(R.id.btnConfirm);
        popup = new Dialog(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomOption.this, CalendarDate.class));
            }
        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i != 0) {
                    singleNum.setText(i - 1);
                }else{
                    Toast.makeText(RoomOption.this, "Nothing happen", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j != 0) {
                    twinNum.setText(j - 1);
                }else{
                    Toast.makeText(RoomOption.this, "Nothing happen", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k != 0) {
                    triNum.setText(k - 1);
                }else{
                    Toast.makeText(RoomOption.this, "Nothing happen", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l != 0) {
                    quadNum.setText(l - 1);
                }else{
                    Toast.makeText(RoomOption.this, "Nothing happen", Toast.LENGTH_SHORT).show();
                }
            }
        });

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 4) {
                    singleNum.setText(i + 1);
                }else{
                    Toast.makeText(RoomOption.this, "Limit Reached", Toast.LENGTH_SHORT).show();
                }
            }
        });

        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j < 4) {
                    twinNum.setText(j + 1);
                }else{
                    Toast.makeText(RoomOption.this, "Limit Reached", Toast.LENGTH_SHORT).show();
                }
            }
        });

        plus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k < 4) {
                    triNum.setText(k + 1);
                }else{
                    Toast.makeText(RoomOption.this, "Limit Reached", Toast.LENGTH_SHORT).show();
                }
            }
        });

        plus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l < 4) {
                    quadNum.setText(l + 1);
                }else{
                    Toast.makeText(RoomOption.this, "Limit Reached", Toast.LENGTH_SHORT).show();
                }
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i != 0){
                    startActivity(new Intent(RoomOption.this, Checkout.class));
                }else if(j != 0){
                    startActivity(new Intent(RoomOption.this, Checkout.class));
                }else if(k != 0) {
                    startActivity(new Intent(RoomOption.this, Checkout.class));
                }else if(l != 0) {
                    startActivity(new Intent(RoomOption.this, Checkout.class));
                }else{
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
