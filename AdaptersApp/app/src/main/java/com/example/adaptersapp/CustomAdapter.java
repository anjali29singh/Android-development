package com.example.adaptersapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] items ;
    public CustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // create a view holder object
        ViewHolder holder;

        if(convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_view,parent,false);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(holder);


        }else{

            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(items[position]);
        return convertView;
    }

    static  class ViewHolder{
        //hold the reference of the view to be displayed
        TextView textView;
    }
}
