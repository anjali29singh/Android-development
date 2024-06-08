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

public class Cube extends AppCompatActivity {

    Button calcBtn;
    EditText cubeLength;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        cubeLength = findViewById(R.id.cube_length);
        calcBtn = findViewById(R.id.calculate_btn);
        result = findViewById(R.id.result);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String side = cubeLength.getText().toString();
                cubeLength.setText(null);
                int length = Integer.parseInt(side);
                int volume = length*length*length;

                result.setText("V = " + volume+" m^3");

            }
        });




    }
}