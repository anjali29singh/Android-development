package com.example.broadcast_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        //this method is called when broadcast receiver receives a broadcast

        if(intent.getAction()!=null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {


            boolean isAirplaneModeOn = intent.getBooleanExtra("state",false);
            String msg = isAirplaneModeOn ? "Airplane Mode is ON" : "Airplane Mode is OFF";
            Toast.makeText(context,""+msg,Toast.LENGTH_SHORT).show();
        }
    }
}
