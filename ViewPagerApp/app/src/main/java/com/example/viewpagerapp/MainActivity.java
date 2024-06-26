package com.example.viewpagerapp;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewpager ;
    MyViewPagerAdapter myAdapter ;

    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            tabLayout = findViewById(R.id.tab_layout);
            myAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),getLifecycle());

            myAdapter.addFragments(new fragment1());
            myAdapter.addFragments(new fragment2());
            myAdapter.addFragments(new fragment3());

            viewpager = findViewById(R.id.viewPager2);
            viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

            viewpager.setAdapter(myAdapter);

            //connect tablyout with viewpager
            new TabLayoutMediator(tabLayout, viewpager, new TabLayoutMediator.TabConfigurationStrategy() {
                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                    tab.setText("Fragment " + (position+1));
                }
            }).attach();

    }
}