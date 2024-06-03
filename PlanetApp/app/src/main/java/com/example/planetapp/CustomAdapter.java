package com.example.planetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetsList;
    Context context;


    public CustomAdapter (ArrayList<Planet> planets , Context context){

        super(context,R.layout.list_item,planets);
        this.planetsList = planets;
        this.context = context;
    }

    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        Planet planet =  getItem(position);

        MyViewHolder myViewHolder ;

        final View result;

        if(convertView==null){

            myViewHolder = new MyViewHolder();

            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.list_item,parent,false);
            myViewHolder.planetName = convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount = convertView.findViewById(R.id.moon_count);
            myViewHolder.planetImg = convertView.findViewById(R.id.imgView);

            result = convertView;
            convertView.setTag(myViewHolder);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());
        return result;
    }


}
