package com.example.englishteacher;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button redBtn ,blueBtn,greenBtn,blackBtn,yellowBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBtn = findViewById(R.id.redBtn);
        blueBtn = findViewById(R.id.blueBtn);
        greenBtn = findViewById(R.id.greenBtn);
        blackBtn = findViewById(R.id.blackBtn);
        yellowBtn = findViewById(R.id.yellowBtn);

        redBtn.setOnClickListener(this);
        blueBtn.setOnClickListener(this);

        greenBtn.setOnClickListener(this);

        blackBtn.setOnClickListener(this);

        yellowBtn.setOnClickListener(this);

    }


    public void onClick(View v){

        int clickedBtnId = v.getId();

        if(clickedBtnId == R.id.redBtn){
            playSound(R.raw.red);
        }else if(clickedBtnId == R.id.blueBtn) {
            playSound(R.raw.blue);
        }else if(clickedBtnId== R.id.greenBtn){
            playSound(R.raw.green);
        }else if(clickedBtnId ==  R.id.yellowBtn)
        {
            playSound(R.raw.yellow);
        } else playSound(R.raw.black);

    }

    public void playSound(int id){

        MediaPlayer mediaPlayer = MediaPlayer.create(this,id);
        mediaPlayer.start();

    }
}