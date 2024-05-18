package com.example.mylearning;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondaryActivity extends AppCompatActivity {

    CheckBox checkBox ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secondary);

        //receive data from another activity

        Intent r = getIntent();
        String receivedData = r.getStringExtra("name");

        checkBox = findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    Toast.makeText(SecondaryActivity.this,"checbox is checked",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(SecondaryActivity.this,"checkbox is unchecked",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       MenuInflater inflater=  getMenuInflater();
       inflater.inflate(R.menu.menu_1,menu);
        return true;
    }

    // to perform actions on menu items


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.search_bar){
            Toast.makeText(this,"you selected search option",Toast.LENGTH_SHORT).show();
        }

        if(itemId == R.id.home){

            Toast.makeText(this,"you selected home option",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}