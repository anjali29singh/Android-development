package com.example.quietarrival;

import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TimeList extends  BaseActivity{

    List<TimeDate> mTimeDateList;


    final Context context = this;
    private RadioButton buttonPlacePick;
    private RadioButton buttonCurrentPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.time_list);
        getLayoutInflater().inflate(R.layout.time_list, frameLayout);

        mDrawerList.setItemChecked(position, true);
        setTitle(listArray[position]);

        populateList();

    }

    public void populateList() {
        TimeController.getInstance().init(this);
        mTimeDataList = TimeController.getInstance().mTimeData;

        TimeDateAdapter adapter = new TimeDateAdapter(this, mTimeDataList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvtimeItems);
        recyclerView.setAdapter(adapter);
    }

}
