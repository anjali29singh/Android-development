package com.example.quietarrival.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quietarrival.R;
import com.example.quietarrival.models.Items;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class NavigationDrawerListAdapter  extends BaseAdapter {

    private Context context;
    private ArrayList<Items> items;


    //store refrences of views
    public  class ViewHolder{

        TextView itemName;
        TextView itemDescription;
        ImageView itemIcon;

    }
    public NavigationDrawerListAdapter(Context context,ArrayList<Items> items){

        this.context = context;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView==null){


            convertView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.drawer_list_item,parent,false);
            holder = new ViewHolder();
            holder.itemName = convertView.findViewById(R.id.item_name_txtview);
//            holder.itemDescription = convertView.findViewById(R.id.;
            holder.itemIcon = convertView.findViewById(R.id.item_icon_imgview);

            convertView.setTag(holder);
        }else {
            holder =(ViewHolder) convertView.getTag();
        }

        Items item = (Items) getItem(position);
        holder.itemName.setText(item.getItemName());
        holder.itemIcon.setBackgroundResource((int)item.getIconId());

        return convertView;
    }
}
