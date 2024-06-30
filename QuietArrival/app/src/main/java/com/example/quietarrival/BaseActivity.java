package com.example.quietarrival;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quietarrival.models.Items;

import java.util.ArrayList;

public class BaseActivity  extends AppCompatActivity {

    private ActionBar actionBar;
    private Toast toast;

    private  long lastBackPressTime=0;
    protected FrameLayout frameLayout;

    protected ListView mDrawerList;


    protected String[] listArray = {"Smart Silent", "Select Place", "Select Time", /*"Settings",*/ "Help", "About Us"};

    protected  ArrayList<Items> listItems;

    protected  static int position;

    private  static  boolean isLaunch = true;

    private DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle actionBarDrawerToggle ;
    private ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#009A9A"));

    //create google client


    @Override
    protected  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.navigation_drawer_base_layout);
        actionBar = getSupportActionBar();

        frameLayout =findViewById(R.id.content_frame);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);

        listItems = new ArrayList<Items>();

        listItems.add(new Items(
                "Home","",R.drawable.home));
        listItems.add(new Items("Select Place","",R.drawable.place));


    }
}