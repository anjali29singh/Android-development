package com.example.volumecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cylinder extends AppCompatActivity {
    EditText radius,height;
    Button calcBtn;

    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        radius = findViewById(R.id.cyc_radius);
        height = findViewById(R.id.cyc_height);
        result = findViewById(R.id.result);
        calcBtn = findViewById(R.id.calculate_btn);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int r = Integer.parseInt(radius.getText().toString());
                int h =  Integer.parseInt(height.getText().toString());

                double volume  = 3.14 * r * r * h;

                result.setText("V =  " + volume + "m^3");
            }
        });


    }
}