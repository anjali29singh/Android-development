package com.example.recyclerview;

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

    //adapterview
    RecyclerView recyclerView;

    MyCustomAdapter myadapter;
    //data source;

    List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();

        Item item1 = new Item(R.drawable.fruits,"Fruits","Fresh Fruits from Garden");
        Item item2  = new Item(R.drawable.vegetables,"Vegetables","Fresh Vegetables from Garden");
        Item item3 = new Item(R.drawable.bread,"Bread","Bread, Wheat and Beans");
        Item item4 = new Item(R.drawable.beverage,"Beverages", "Juice , Tea , Coffee");
        Item item5 = new Item(R.drawable.milk, "Milk","Yummy Milk from Dairy");
        Item item6 = new Item(R.drawable.ice_cream,"Ice Cream","Delicious , Fruit Ice Cream");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myadapter = new MyCustomAdapter(itemList);
        recyclerView.setAdapter(myadapter);

    }
}