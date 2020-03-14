package com.example.loginproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button btnContinue;
    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnContinue = (Button)findViewById(R.id.btnContinue);
        tabLayout = (TabLayout)findViewById(R.id.tablayoutid);
        viewPager = (ViewPager)findViewById(R.id.homeViewPager);
        imageSlider = (ImageSlider)findViewById(R.id.homeSlider);

        AdapterHome adapter = new AdapterHome(getSupportFragmentManager());
        //Adding fragment
        adapter.AddFragment(new FragmentAboutUs(), "About Us");
        adapter.AddFragment(new FragmentAmenities(), "Amenities");
        adapter.AddFragment(new FragmentContact(), "Contact");
        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        firebaseAuth = FirebaseAuth.getInstance();

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityHome.this, ActivityBooking.class));
            }
        });

        List<SlideModel> slideModel = new ArrayList<>();
        slideModel.add(new SlideModel(R.drawable.hautel1));
        slideModel.add(new SlideModel(R.drawable.hautel2));
        slideModel.add(new SlideModel(R.drawable.hautel3));
        imageSlider.setImageList(slideModel, true);
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(ActivityHome.this, ActivityLogin.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logoutMenu:{
                Logout();
                break;
            }
            case R.id.profileMenu: {
                startActivity(new Intent(ActivityHome.this, ActivityProfile.class));
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
