package com.example.quietarrival;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quietarrival.adapter.NavigationDrawerListAdapter;
import com.example.quietarrival.models.Items;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

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

    private OnBackPressedDispatcher onBackPressDispatcher;

    private FusedLocationProviderClient fusedLocationClient;
    //create google client


    @Override
    protected  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.navigation_drawer_base_layout);
        actionBar = getSupportActionBar();

        frameLayout =findViewById(R.id.content_frame);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);

        onBackPressDispatcher = getOnBackPressedDispatcher();

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        listItems = new ArrayList<Items>();

        listItems.add(new Items(
                "Home","",R.drawable.home));
        listItems.add(new Items("Select Place","",R.drawable.place));

        listItems.add(new Items("Select Time","",R.drawable.timepick));

        listItems.add(new Items("Help","",R.drawable.help));

        listItems.add(new Items("About Us","",R.drawable.aboutus));

        mDrawerList.setAdapter(new NavigationDrawerListAdapter(this,listItems));

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                openActivity(position);
            }
        });

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setBackgroundDrawable(colorDrawable);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,mDrawerLayout,R.string.open_drawer,R.string.close_drawer
        ){


            @Override
            public void onDrawerClosed(View draweView){
                actionBarDrawerToggle.syncState();;
                invalidateOptionsMenu();
                super.onDrawerClosed(draweView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBarDrawerToggle.syncState();
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }

        };


        onBackPressDispatcher.addCallback(this, new OnBackPressedCallback(true){
            @Override
            public void handleOnBackPressed() {

                handleBackPressed();
            }
        });
    }

    protected  void openActivity(int position){

        mDrawerLayout.closeDrawer(mDrawerList);
        BaseActivity.position = position;

        switch (position) {
            case 0:
                startActivity(new Intent(this, HomeActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, PlaceCurrent.class));
                break;
            case 2:
                startActivity(new Intent(this, TimeActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, HelpActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, AboutUs.class));
                break;

            default:
                break;
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == android.R.id.home) {
            toggle();

        }
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
//		return super.onOptionsItemSelected(item);

    }

    private void toggle() {
        if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }



    public  void handleBackPressed(){


                    if(mDrawerLayout.isDrawerOpen(mDrawerList)) {

                        mDrawerLayout.closeDrawer(mDrawerList);
                    }else{

                        if(System.currentTimeMillis()-4000 > lastBackPressTime){

                            LayoutInflater inflater = getLayoutInflater();
                            View  layout = inflater.inflate(R.layout.toast,(ViewGroup)findViewById(R.id.custom_toast_container));

                            TextView text = (TextView) layout.findViewById(R.id.text);
                            text.setText("Press back again to close this app");
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.setView(layout);
                            toast.show();
                            lastBackPressTime = System.currentTimeMillis();

                        }
                        else{
                            if (toast != null) {
                                toast.cancel();
                            }

                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }



            }



}