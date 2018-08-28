package com.example.a06079050188.projetomaratonei;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SeriesAdapter  extends RecyclerView.Adapter<SeriesAdapter.MeuViewHolder>{



    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_serie,parent,false);

        return new MeuViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {

        holder.textNomeSerie.setText("Nome da Serie");
        holder.bannerSerie.setImageResource(R.drawable.vingadores);

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    //Cria classe interna para o ViewHolder
    public class MeuViewHolder extends RecyclerView.ViewHolder{

        private TextView textNomeSerie;
        private ImageView bannerSerie;

        //Construtor do View Holder
        public MeuViewHolder(View itemView) {
            super(itemView);
            textNomeSerie = itemView.findViewById(R.id.textNomeSerie);
            bannerSerie = itemView.findViewById(R.id.bannerSerie);

        }
    }



}
