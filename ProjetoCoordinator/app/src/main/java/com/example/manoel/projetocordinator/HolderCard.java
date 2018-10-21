package com.example.manoel.projetocordinator;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class HolderCard extends RecyclerView.ViewHolder {
    private TextView texto ;

    public HolderCard(@NonNull View itemView) {
        super(itemView);
        texto = itemView.findViewById(R.id.textView);
    }

    public TextView getTexto() {
        return texto;
    }

    public void setTexto(TextView texto) {
        this.texto = texto;
    }
}
