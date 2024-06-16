package com.example.counterapp;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class MyViewModal extends BaseObservable {

    int counter;

    MyViewModal(){

        counter = 0;
    }
    @Bindable
    public  String getCounter(){
        return ""+counter;
    }
    public void increaseCounter(View view){
        counter++;
        notifyPropertyChanged(BR.counter);
    }


}
