package com.facto.manoel.tablayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facto.manoel.tablayout.status.Status;
import com.facto.manoel.tablayout.status.StatusHolder;

import java.util.ArrayList;

public class AdapterStatus extends RecyclerView.Adapter<StatusHolder> {

    private Context context;
    private ArrayList<Status> statusArrayList;

    public AdapterStatus(Context context, ArrayList<Status> statusArrayList){

        this.context = context;
        this.statusArrayList = statusArrayList;
    }


    @NonNull
    @Override
    public StatusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cell = LayoutInflater.from(this.context).inflate(R.layout.celula_status,parent,false);
        StatusHolder holder = new StatusHolder(cell);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StatusHolder holder, int position) {

        Status conversas = statusArrayList.get(position);
        holder.getNome().setText(conversas.getNome());
        holder.getImagem().setImageBitmap(conversas.getImagem());

    }

    @Override
    public int getItemCount() {
        return statusArrayList.size();
    }
}
