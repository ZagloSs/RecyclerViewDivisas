package com.zagloss.recyclerviewdivisas;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DvRvAdapter extends RecyclerView.Adapter<DvRvAdapter.MyViewHolder> {

    Context context;
    ArrayList<DvModel> dvModels;

    public DvRvAdapter(Context context, ArrayList<DvModel> dvModels) {
        this.context = context;
        this.dvModels = dvModels;
    }

    @NonNull
    @Override
    public DvRvAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.cv_row, parent, false);

        return new DvRvAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DvRvAdapter.MyViewHolder holder, int position) {
        holder.tvNombre.setText(dvModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dvModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById((R.id.divisa));
        }
    }
}
