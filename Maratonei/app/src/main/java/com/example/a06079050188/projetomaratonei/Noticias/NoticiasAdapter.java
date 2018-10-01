package com.example.a06079050188.projetomaratonei.Noticias;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a06079050188.projetomaratonei.Filmes.FilmesAdapter;
import com.example.a06079050188.projetomaratonei.R;

import java.util.ArrayList;
import java.util.List;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.NoticiaHolder> {


    private List<Noticia> noticias = new ArrayList<>();

    @NonNull
    @Override
    public NoticiaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_noticias,parent,false);
        noticias.add(new Noticia("Noticia 01", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 02", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 03", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 04", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 05", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 06", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 07", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 08", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 09", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 10", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 11", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 12", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 13", "2018-08-10","stringNoticia",123,"urlTrailer"));
        noticias.add(new Noticia("Noticia 14", "2018-08-10","stringNoticia",123,"urlTrailer"));

        return new NoticiaHolder(itemLista);


    }

    @Override
    public void onBindViewHolder(@NonNull NoticiaHolder holder, int position) {
        Noticia noticia = noticias.get(position);

        holder.txtNoticia.setText(noticia.getTituloNoticia());
        holder.dataNoticia.setText(noticia.getDataNoticia());

    }

    @Override
    public int getItemCount() {
        Log.i("INFO", "tamanho: " +noticias.size());
        return noticias.size();

    }

    public class NoticiaHolder extends RecyclerView.ViewHolder{

        private TextView txtNoticia;
        private TextView dataNoticia;
        //Construtor do View Holder
        public NoticiaHolder(View itemView) {
            super(itemView);
            txtNoticia = itemView.findViewById(R.id.txtTituloNoticia);
            dataNoticia = itemView.findViewById(R.id.txtDataNoticia);
        }
    }


}
