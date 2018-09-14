package com.example.fc20163243.myphome.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.fc20163243.myphome.R;

import org.w3c.dom.Text;


public class FoodHolder extends RecyclerView.ViewHolder {
    private TextView nomeComida;
    private RatingBar starComida;
    private ImageView imageComida;


    public FoodHolder(View itemView) {
        super(itemView);

        nomeComida = itemView.findViewById(R.id.celula_nome_comida);
        starComida = itemView.findViewById(R.id.starComida);
        imageComida = itemView.findViewById(R.id.imageComida);


    }


    public TextView getNomeComida() {
        return nomeComida;
    }

    public void setNomeComida(TextView nomeComida) {
        this.nomeComida = nomeComida;
    }

    public RatingBar getStarComida() {
        return starComida;
    }

    public void setStarComida(RatingBar starComida) {
        this.starComida = starComida;
    }

    public ImageView getImageComida() {
        return imageComida;
    }

    public void setImageComida(ImageView imageComida) {
        this.imageComida = imageComida;
    }
}
