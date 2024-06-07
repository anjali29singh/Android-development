package com.example.volumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapesList;
    Context context;

    public MyCustomAdapter(ArrayList<Shape> shapesList,@NonNull Context context) {
        super(context, R.layout.grid_item_layout,shapesList);
        this.shapesList = shapesList;
        this.context = context;
    }

    //View Holder : it hold refrences to views within item layout

    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImg;

    }

    // GetView() : used to create and return a view for specific item in grid


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get shape object for the current position
        Shape shapes = getItem(position);

        //2. inflating layout
        MyViewHolder myViewHolder;

        if(convertView==null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.grid_item_layout,parent,false);

            //find views;
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.shape_name);
            myViewHolder.shapeImg =  (ImageView) convertView.findViewById(R.id.shape_img);
            convertView.setTag(myViewHolder);

        }
        else{
        // a view went off screen
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        //getting data from modal class;
        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImg.setImageResource(shapes.getShape());
        return convertView;

    }
}
