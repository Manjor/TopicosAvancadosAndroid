package com.example.a06079050188.projetomaratonei;

public class Filme {

    private String nomeFilme;
    private String imagemFilme;
    private int idFilme;

    public Filme(){}
    //Construtor da Classe Filme
    public Filme(String nomeFilme, String imagemFilme, int idFilme) {
        this.nomeFilme = nomeFilme;
        this.imagemFilme = imagemFilme;
        this.idFilme = idFilme;
    }


    //Getters e Setters para acesso aos atributos
    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getImagemFilme() {
        return imagemFilme;
    }

    public void setImagemFilme(String imagemFilme) {
        this.imagemFilme = imagemFilme;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }
}
