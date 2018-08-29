package com.example.a06079050188.projetomaratonei;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SeriesAdapter  extends RecyclerView.Adapter<SeriesAdapter.MeuViewHolder>{

    private List<Serie> series;

    public SeriesAdapter(List<Serie> Listaserie) {

        this.series = Listaserie;
    }

    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_serie,parent,false);

        return new MeuViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull final MeuViewHolder holder, int position) {


        final Serie serie = series.get(position);
        //Seta no textNomeSeie o valor recebido pelo construtor de Serie
        holder.textNomeSerie.setText(serie.getNomeSerie());
        final int id = serie.getIdSerie();
        Picasso.get().load(serie.getImagemSerie()).into(holder.bannerSerie);
        Log.i("INFO","URL: " + serie.getImagemSerie());
        holder.bannerSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cria um intent que recebe o contexto,e a proxima classe a ser chamada
                Intent it = new Intent(view.getContext(),DetalhesSeries.class);
                Bundle bundle = new Bundle();
                Log.i("INFO", "id:" + id);

                //Envia parametros pelo intent
                //Nesse caso o id do filme selecionado
                it.putExtra("id", id);
                //Para direcionar para o intent é necessário chamar o metodo startActivity
                //pelo contexto atual

                view.getContext().startActivity(it);

            }
        });

    }

    @Override
    public int getItemCount() {
        return 19;
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
