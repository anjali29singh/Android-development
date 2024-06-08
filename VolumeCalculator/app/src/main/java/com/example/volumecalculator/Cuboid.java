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

public class Cuboid extends AppCompatActivity {

    Button calcBtn;
    EditText length,breadth,height;

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuboid);

        calcBtn = findViewById(R.id.calculate_btn);
        length = findViewById(R.id.length);
        breadth = findViewById(R.id.breadth);
        height = findViewById(R.id.height);
        result = findViewById(R.id.result);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int l = Integer.parseInt(length.getText().toString());
                int b = Integer.parseInt(breadth.getText().toString());
                int h = Integer.parseInt(height.getText().toString());
                length.setText(null);
                breadth.setText(null);
                height.setText(null);

                int volume = l*b*h;
                result.setText("V = "+volume+" m^3");
            }
        });


    }
}