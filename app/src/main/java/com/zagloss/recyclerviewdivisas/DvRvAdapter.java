package com.zagloss.recyclerviewdivisas;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DvRvAdapter extends RecyclerView.Adapter<DvRvAdapter.MyViewHolder> {

    Context context;
    ArrayList<DvModel> dvModels;
    DvModel divisaSelec;

    int posicionMarcada = 0;

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
        holder.tvCambio.setText("1€ son " + String.valueOf(dvModels.get(position).getCantidad()) + dvModels.get(position).getMoneda());

        final int pos = position;
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicionMarcada = pos;
                System.out.println(posicionMarcada );
                notifyDataSetChanged();

            }
        });

        if(posicionMarcada == position){
            holder.cv.getBackground().setTint(Color.parseColor("#4e4e4e"));
            divisaSelec = dvModels.get(position);
        }else{
            holder.cv.getBackground().setTint(Color.parseColor("#3e3e3e"));
        }



    }

    @Override
    public int getItemCount() {
        return dvModels.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre;
        CardView cv;
        TextView tvCambio;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById((R.id.divisa));
            cv = itemView.findViewById(R.id.cardDivisa);
            tvCambio = itemView.findViewById(R.id.cambio);
        }
    }
}
