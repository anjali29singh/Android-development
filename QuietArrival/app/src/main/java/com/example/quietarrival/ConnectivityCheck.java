package com.example.quietarrival;

import android.content.Context;
import android.net.ConnectivityManager;

public class ConnectivityCheck {

    public static final boolean CheckInternetConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnectedOrConnecting()) {
            return true;

        } else {
            return false;
        }



    }
}
