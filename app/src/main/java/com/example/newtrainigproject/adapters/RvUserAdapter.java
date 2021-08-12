package com.example.newtrainigproject.adapters;

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

public class RvUserAdapter extends RecyclerView.Adapter<RvUserAdapter.ViewHolder> {
    Context context;
    List<LoginRegistrationModel> modelList = new ArrayList<>();

    public RvUserAdapter(Context context, List<LoginRegistrationModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    public void upDateAdapter(List<LoginRegistrationModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RvUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvUserAdapter.ViewHolder holder, int position) {
        holder.tvSlNo.setText(String.valueOf(position + 1));
        holder.tvName.setText(modelList.get(position).getName());
        holder.tvUserName.setText(modelList.get(position).getUsername());
        holder.tvEmail.setText(modelList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSlNo;
        TextView tvName;
        TextView tvUserName;
        TextView tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSlNo = itemView.findViewById(R.id.tvSlNo);
            tvName = itemView.findViewById(R.id.tvName);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}
