package com.example.viewpagerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewpager ;
    MyViewPagerAdapter myAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            myAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),getLifecycle());

            myAdapter.addFragments(new fragment1());
            myAdapter.addFragments(new fragment2());
            myAdapter.addFragments(new fragment3());

            viewpager = findViewById(R.id.viewPager2);
            viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

            viewpager.setAdapter(myAdapter);
    }
}