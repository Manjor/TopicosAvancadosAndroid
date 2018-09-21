package com.facto.manoel.tablayout.Conversas;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facto.manoel.tablayout.R;

public class ConversasHolder extends RecyclerView.ViewHolder {

    private ImageView imagem ;
    private TextView nome;
    private TextView mensagemRecente;


    public ConversasHolder(View itemView){
        super(itemView);

        imagem = itemView.findViewById(R.id.celula_imagem);
        nome = itemView.findViewById(R.id.celula_nome);
        mensagemRecente = itemView.findViewById(R.id.celuala_msg);
    }

    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getMensagemRecente() {
        return mensagemRecente;
    }

    public void setMensagemRecente(TextView mensagemRecente) {
        this.mensagemRecente = mensagemRecente;
    }
}
