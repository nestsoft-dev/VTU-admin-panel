package com.netsoftddevelopers.vtuadmin.Core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.netsoftddevelopers.vtuadmin.R;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<ItemModel> {
    public ItemAdapter(Context context, ArrayList<ItemModel> itemModelArrayList){
        super(context,0,itemModelArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initview(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initview(position,convertView,parent);
    }

    private View initview(int position,View convertView,ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_lay,parent,false
            );
        }

        ImageView network_icon = convertView.findViewById(R.id.img);
        TextView network_name = convertView.findViewById(R.id.networkName);

        ItemModel itemModel = getItem(position);

        if (itemModel !=null) {
            network_icon.setImageResource(itemModel.getNetwork_icon());
            network_name.setText(itemModel.getNetwork_name());
        }
        return convertView;
    }


}
