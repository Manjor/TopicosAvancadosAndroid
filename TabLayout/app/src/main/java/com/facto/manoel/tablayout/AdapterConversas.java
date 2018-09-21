package com.facto.manoel.tablayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facto.manoel.tablayout.Conversas.Conversas;
import com.facto.manoel.tablayout.Conversas.ConversasHolder;

import java.util.ArrayList;

public class AdapterConversas extends RecyclerView.Adapter<ConversasHolder> {

    private Context context;
    private ArrayList<Conversas> statusArrayList;

    public AdapterConversas(Context context, ArrayList<Conversas> statusArrayList){

        this.context = context;
        this.statusArrayList = statusArrayList;
    }


    @NonNull
    @Override
    public ConversasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cell = LayoutInflater.from(this.context).inflate(R.layout.celula_conversa,parent,false);
        ConversasHolder holder = new ConversasHolder(cell);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConversasHolder holder, int position) {

        Conversas status = statusArrayList.get(position);
        holder.getNome().setText(status.getNome());
        holder.getImagem().setImageBitmap(status.getImagem());
        holder.getMensagemRecente().setText(status.getMensagemRecente());


    }

    @Override
    public int getItemCount() {
        return statusArrayList.size();
    }
}
