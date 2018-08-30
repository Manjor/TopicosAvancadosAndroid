package com.example.a06079050188.projetomaratonei;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.MeuViewHolder>{

    //Lista que irá receber os filmes para exibição dos cards
    private List<Filme> filmes;

    //Construtor do Adapter Recebe uma lista como parametro
    public FilmesAdapter(List<Filme> Listafilmes) {
        this.filmes = Listafilmes;
    }


    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_filme,parent,false);

        return new MeuViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {

        Filme filme = filmes.get(position);
        holder.textFilme.setText(filme.getNomeFilme());
        final int id = filme.getIdFilme();
        //Chama a biblioteca Picasso que irá processar a url do filme e inserir
        //Na imageView
        Picasso.get().load(filme.getImagemFilme()).into(holder.imagemFilme);
        Log.i("INFO","URL: " + filme.getImagemFilme());

    }

    @Override
    public int getItemCount() {
        return 20;
    }
    //Cria classe interna para o ViewHolder
    public class MeuViewHolder extends RecyclerView.ViewHolder{

        private TextView textFilme;
        private ImageView imagemFilme;

        //Construtor do View Holder
        public MeuViewHolder(View itemView) {

            super(itemView);
            textFilme = itemView.findViewById(R.id.textFilme);
            imagemFilme = itemView.findViewById(R.id.imagemFilme);

        }
    }
}


