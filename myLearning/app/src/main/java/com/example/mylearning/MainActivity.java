package com.example.mylearning;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


   /**     spinner = findViewById(R.id.spinner);


        //create adapter for spinner, listview,gridview

        String[] courses ={"C++","Java","Python","Kotlin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,courses);


        spinner.setAdapter(adapter);

    **/


       /* Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                goToSecondActivity();

                //pass data between activities

                Intent i = new Intent(getApplicationContext(), SecondaryActivity.class);
                String data="anjali";
                i.putExtra("name",data);
                startActivity(i);

                //share data among different components of  application or different application in android


            }
        });

/
        */
      /*  Button webBtn = findViewById(R.id.webBtn);
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebpage();
            }
        });

    }
    */
       */
    /*public void goToSecondActivity(){

        Intent intent = new Intent(this, SecondaryActivity.class);
        startActivity(intent);
    }

    public void openWebpage(){
        Uri webpage = Uri.parse("https://www.udemy.com/course/the-complete-android-10-developer-course-mastering-android/learn/lecture/34657174#content");
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);

        startActivity(webIntent);

    }

*/

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