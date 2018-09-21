package com.facto.manoel.tablayout.status;

import android.graphics.Bitmap;

public class Status {

    private Bitmap imagem;
    private String nome;

    public Status(Bitmap imagem, String nome) {
        this.imagem = imagem;
        this.nome = nome;
    }

    public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
