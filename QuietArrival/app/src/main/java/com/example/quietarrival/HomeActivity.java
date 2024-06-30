package com.example.quietarrival;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        getLayoutInflater().inflate(R.layout.home_main,frameLayout);

        mDrawerList.setItemChecked(position, true);
        setTitle(listArray[position]);

    }
}
