package com.example.adaptersapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        // AdapterView  = container (ListView)

        //data source

        String[] data_source  = {"C++","Python","Kotlin","Golang","Java","Javascript"};

        // Adapter  = bridge between data source and adapter view

//        ArrayAdapter<String>  myadapter  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data_source);

        CustomAdapter adapter = new CustomAdapter(this,data_source);
        listView.setAdapter(adapter);


    }
}