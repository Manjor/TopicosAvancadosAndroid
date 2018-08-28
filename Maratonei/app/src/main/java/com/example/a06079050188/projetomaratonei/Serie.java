package com.example.a06079050188.projetomaratonei;

public class Serie {

    private String nomeSerie ;
    private int imagemSerie;
    private int idSerie;


    public Serie(){}
    public Serie(String nomeSerie, int imagemSerie, int idSerie){

        this.nomeSerie = nomeSerie;
        this.imagemSerie = imagemSerie;
        this.idSerie = idSerie;
    }



    public String getNomeSerie() {
        return nomeSerie;
    }

    public void setNomeSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    public int getImagemSerie() {
        return imagemSerie;
    }

    public void setImagemSerie(int imagemSerie) {
        this.imagemSerie = imagemSerie;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }
}
