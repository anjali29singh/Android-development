package com.example.mylearning;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });

        Button webBtn = findViewById(R.id.webBtn);
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebpage();
            }
        });

    }
    public void goToSecondActivity(){

        Intent intent = new Intent(this, SecondaryActivity.class);
        startActivity(intent);
    }

    public void openWebpage(){
        Uri webpage = Uri.parse("https://www.udemy.com/course/the-complete-android-10-developer-course-mastering-android/learn/lecture/34657174#content");
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);

        startActivity(webIntent);

    }


//    @Override
//    protected  void onStart(){
//
//        super.onStart();
//        Toast.makeText(this, "onStart is called", Toast.LENGTH_SHORT).show();
//    }
//
//
//    @Override
//    protected  void onResume(){
//        super.onResume();
//        Toast.makeText(this,"onResume is called", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected  void onPause(){
//        super.onPause();
//        Toast.makeText(this,"onPause is called", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected  void onStop(){
//        super.onStop();
//        Toast.makeText(this,"onStop is called", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected  void onDestroy(){
//        super.onDestroy();
//        Toast.makeText(this,"onDestroy is called", Toast.LENGTH_SHORT).show();
//    }


}