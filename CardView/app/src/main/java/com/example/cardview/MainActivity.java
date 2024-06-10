package com.example.cardview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private  List<Sport> sportList;
   private RecyclerView recyclerView;
   private  MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sportList = new ArrayList<>();

        Sport s1 = new Sport("BasketBall",R.drawable.basketball);
        Sport s2  = new Sport("Football",R.drawable.football);
        Sport s3  = new Sport("Tennis",R.drawable.tennis);
        Sport s4  = new Sport("VolleyBall",R.drawable.volley);
        Sport s5  = new Sport("Ping",R.drawable.ping);

        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(sportList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}