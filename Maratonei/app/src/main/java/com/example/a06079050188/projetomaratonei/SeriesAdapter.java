package com.example.a06079050188.projetomaratonei;

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
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {

        Serie serie = series.get(position);
        holder.textNomeSerie.setText(serie.getNomeSerie());
        Picasso.get().load(serie.getImagemSerie()).into(holder.bannerSerie);
        Log.i("INFO","URL: " + serie.getImagemSerie());

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
