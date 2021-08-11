package com.example.newtrainigproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newtrainigproject.R;
import com.example.newtrainigproject.model.AddItemModel;

import java.util.ArrayList;
import java.util.List;

public class RvViewItemAdapter extends RecyclerView.Adapter<RvViewItemAdapter.ViewItemHodler> {
    Context context;
    List<AddItemModel> modelList=new ArrayList<>();
    public RvViewItemAdapter(Context context,List<AddItemModel> modelList){
        this.context=context;
        this.modelList=modelList;
    }
    public void updateView(List<AddItemModel> modelList){
        this.modelList=modelList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RvViewItemAdapter.ViewItemHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_item_layout,parent,false);
        return new ViewItemHodler(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RvViewItemAdapter.ViewItemHodler holder, int position) {
        holder.tvSlNoView.setText(String.valueOf(position+1));
        holder.tvStatesView.setText(modelList.get(position).getState());
        holder.tvDistrictView.setText(modelList.get(position).getDistrict());
        holder.tvPinCodeView.setText(modelList.get(position).getPinCode());
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewItemHodler extends RecyclerView.ViewHolder {
        TextView tvSlNoView;
        TextView tvStatesView;
        TextView tvDistrictView;
        TextView tvPinCodeView;
        public ViewItemHodler(@NonNull View itemView) {
            super(itemView);
            tvSlNoView=itemView.findViewById(R.id.tvSlNoView);
            tvStatesView=itemView.findViewById(R.id.tvStatesView);
            tvDistrictView=itemView.findViewById(R.id.tvDistrictView);
            tvPinCodeView=itemView.findViewById(R.id.tvPinCodeView);
        }
    }
}
