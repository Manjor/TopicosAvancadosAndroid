package com.example.manoel.projetocordinator;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class AdapterCard extends RecyclerView.Adapter<HolderCard>{

    private List<Card> cards = new ArrayList<>();
    public AdapterCard(List<Card> cards){
        this.cards = cards;
    }

    @NonNull
    @Override
    public HolderCard onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemList = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_teste,viewGroup,false);

        return new HolderCard(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCard holderCard, int i) {

        Card card = cards.get(i);

        holderCard.getTexto().setText(card.getTexto());

    }

    @Override
    public int getItemCount() {
        return this.cards.size();
    }
}