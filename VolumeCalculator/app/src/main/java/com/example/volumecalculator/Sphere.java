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

public class Sphere extends AppCompatActivity {

    Button calcBtn;
    EditText sphere_radius;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
      sphere_radius = findViewById(R.id.sphere_radius);
      calcBtn = findViewById(R.id.calculate_btn);
      result= findViewById(R.id.result_textView);

      calcBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String  radius = sphere_radius.getText().toString();
              sphere_radius.setText(null);
              int r = Integer.parseInt(radius);

              double volume = (4/3)*3.14*(r*r*r);

              result.setText("V = " + volume +" m^3");

          }
      });
    }
}