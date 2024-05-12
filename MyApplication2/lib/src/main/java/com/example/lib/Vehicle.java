package com.example.lib;
//parent class
public abstract class Vehicle{

    int numOfWheels;

    public Vehicle(int wheels){
        this.numOfWheels=wheels;
    }
    void sayHello(){
        System.out.println("say hellow");
    }
    abstract  void absMethod();
}
