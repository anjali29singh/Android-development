package com.example.volumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Shape> shapeList;

    MyCustomAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        shapeList = new ArrayList<>();

        Shape shape1 = new Shape(R.drawable.cube,"Cube");
        Shape shape2 = new Shape(R.drawable.cuboid,"Cuboid");
        Shape shape3 = new Shape(R.drawable.cylinder,"Cylinder");
        Shape shape4 = new Shape(R.drawable.sphere,"Sphere");
        shapeList.add(shape1);
        shapeList.add(shape2);
        shapeList.add(shape3);
        shapeList.add(shape4);

        myadapter = new MyCustomAdapter(shapeList,getApplicationContext());
        gridView.setAdapter(myadapter);
        gridView.setNumColumns(2);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Shape s = shapeList.get(position);
                if(s.getShapeName() == "Sphere") {
                    Intent intent =  new Intent(getApplicationContext(), Sphere.class);
                    startActivity(intent);
                }
                else if(s.getShapeName() == "Cube") {
                    Intent intent =  new Intent(getApplicationContext(), Cube.class);
                    startActivity(intent);
                }
                else if(s.getShapeName() == "Cuboid") {
                    Intent intent =  new Intent(getApplicationContext(), Cuboid.class);
                    startActivity(intent);
                }
                else if(s.getShapeName() == "Cylinder") {
                    Intent intent =  new Intent(getApplicationContext(), Cylinder.class);
                    startActivity(intent);
                }
            }
        });
    }
}