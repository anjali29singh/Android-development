package com.example.planetapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetArrayList;
    private   CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //1. adapterview
        listView = findViewById(R.id.listView);

        //2. data source
        planetArrayList = new ArrayList<>();

        Planet planet1 = new Planet("earth","1",R.drawable.earth);
        planetArrayList.add(planet1);
        Planet planet2 = new Planet("mars","3",R.drawable.mars);
        planetArrayList.add(planet2);
        Planet planet3 = new Planet("jupiter","5",R.drawable.jupiter);
        planetArrayList.add(planet3);
        Planet planet4 = new Planet("saturn","9",R.drawable.saturn);
        planetArrayList.add(planet4);

        //adapter
        adapter = new CustomAdapter(planetArrayList,getApplicationContext());

        listView.setAdapter(adapter);

    }
}