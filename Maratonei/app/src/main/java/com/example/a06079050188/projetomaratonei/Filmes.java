package com.example.a06079050188.projetomaratonei;

public class Filmes {

    private String nomeFilme;



    public String getNomeFilme()
    {
        return this.nomeFilme;
    }

    public void setNomeFilme(String nomeFilme)
    {
        this.nomeFilme = nomeFilme;
    }


    @Override
    public String toString()
    {
        return "Filme: " + getNomeFilme();
    }
}
