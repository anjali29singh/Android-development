package com.example.broadcast_reciever;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        AirplaneModeReceiver br = new AirplaneModeReceiver();
        registerReceiver(br,intentFilter);

    }
}