package com.example.cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.SportsViewHoder> {

    private List<Sport> sportList;

    public  MyAdapter(List<Sport> sportList){
        this.sportList = sportList;
    }
    @NonNull
    @Override
    public SportsViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_item,parent,false);
        return new SportsViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHoder holder, int position) {

        Sport sport = sportList.get(position);
        holder.sportImg.setImageResource(sport.getSportImg());
        holder.sportName.setText(sport.getSportName());
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    public  static  class SportsViewHoder extends RecyclerView.ViewHolder{

        TextView sportName;
        ImageView sportImg;

        public SportsViewHoder(@NonNull View itemView) {
            super(itemView);
            sportName = itemView.findViewById(R.id.textView);
            sportImg =  itemView.findViewById(R.id.imageView);
        }
    }


}
