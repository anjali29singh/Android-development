package com.example.quadraticequation;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequation.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {

    String a;
    String b;
    String c;
    ActivityMainBinding binding;


    public MyEquation(ActivityMainBinding binding){
        this.binding = binding;
    }

    public MyEquation(String a, String b, String c){

        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Bindable

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
        notifyPropertyChanged(BR.a);
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
        notifyPropertyChanged(BR.b);
    }

    @Bindable
    public String getC() {
        return c;
    }


    public void setC(String c) {
        this.c = c;
        notifyPropertyChanged(BR.c);
    }

    public void solve(View view){
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        double discriminant = (b*b)- 4 * a * c;
        if (discriminant>0){
            double x1,x2;
            x1 = -b +(Math.sqrt(discriminant))/(2*a);
            x2 = -b - (Math.sqrt(discriminant))/(2*a);
            //display the result
            binding.textView3.setText("X1: "+x1 + "X2: " + x2);

        }else if(discriminant<0) {
            binding.textView3.setText("No solution since no real roots");
        }
        else {
            double x1 = -b/(2*a);
            binding.textView3.setText("Equal roots" + "X1 = X2 : " + x1);
        }

    }
}
