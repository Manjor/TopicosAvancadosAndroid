package com.facto.manoel.tablayout.Conversas;

import android.graphics.Bitmap;

public class Conversas {

    private Bitmap imagem;
    private String nome;
    private String mensagemRecente;

    public Conversas(Bitmap imagem, String nome, String mensagemRecente) {
        this.imagem = imagem;
        this.nome = nome;
        this.mensagemRecente = mensagemRecente;
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

    public String getMensagemRecente() {
        return mensagemRecente;
    }

    public void setMensagemRecente(String mensagemRecente) {
        this.mensagemRecente = mensagemRecente;
    }
}
