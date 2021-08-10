package com.example.newtrainigproject.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newtrainigproject.R;
import com.example.newtrainigproject.model.LoginRegistrationModel;

import java.util.ArrayList;
import java.util.List;

public class UserRvAdapter extends RecyclerView.Adapter<UserRvAdapter.ViewHolder> {
    Context context;
    List<LoginRegistrationModel> modelList = new ArrayList<>();

    public UserRvAdapter(Context context, List<LoginRegistrationModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void updateAdapter(List<LoginRegistrationModel> modelList){
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.users_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvSlNo.setText(String.valueOf(position + 1));
        holder.tvName.setText(modelList.get(position).getName());
        holder.tvUserName.setText(modelList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSlNo;
        TextView tvName;
        TextView tvUserName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvSlNo = itemView.findViewById(R.id.tvSlNo);
            tvUserName = itemView.findViewById(R.id.tvUserName);
        }
    }
}
