package com.netsoftddevelopers.vtuadmin.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.netsoftddevelopers.vtuadmin.R;
import com.netsoftddevelopers.vtuadmin.UpdateActivity;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHoder> {
    Context context;
    ArrayList<ListModel> listModels;

    public MyListAdapter(Context context, ArrayList<ListModel> listModels) {
        this.context = context;
        this.listModels = listModels;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHoder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
        ListModel model = listModels.get(position);
        holder.planAmount.setText("Plan Amount: "+model.getPlanAmount());
        holder.planid.setText("Plan id: "+model.getPlanID());
        holder.dataSize.setText("Data size: "+model.getDataSize());
        holder.planType.setText("Plan Type: "+model.getPlanType());

        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, UpdateActivity.class);
                        intent.putExtra("id",listModels.get(position).getiD());

                        intent.putExtra("planAmount",listModels.get(position).getPlanAmount());
                        intent.putExtra("planid",listModels.get(position).getPlanID());
                        intent.putExtra("datasize",listModels.get(position).getDataSize());
                        intent.putExtra("plantype",listModels.get(position).getPlanType());

                        context.startActivity(intent);
                    }
                }
        );


    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public  class MyViewHoder extends RecyclerView.ViewHolder{
        TextView planType,planid,dataSize,planAmount;
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            planType = itemView.findViewById(R.id.planType);
            planid = itemView.findViewById(R.id.planid);
            dataSize = itemView.findViewById(R.id.dataSize);
            planAmount = itemView.findViewById(R.id.planAmount);
        }
    }
}
