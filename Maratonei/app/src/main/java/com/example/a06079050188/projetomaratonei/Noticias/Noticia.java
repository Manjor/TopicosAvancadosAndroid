package com.example.a06079050188.projetomaratonei.Noticias;

public class Noticia {


    private String tituloNoticia;
    private String dataNoticia;
    private String imagemNoticia;
    private int idMidia;
    private String urlTrailer;

    public Noticia(){}

    public Noticia(String tituloNoticia, String dataNoticia, String imagemNoticia, int idMidia, String urlTrailer) {
        this.tituloNoticia = tituloNoticia;
        this.dataNoticia = dataNoticia;
        this.imagemNoticia = imagemNoticia;
        this.idMidia = idMidia;
        this.urlTrailer = urlTrailer;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getDataNoticia() {
        return dataNoticia;
    }

    public void setDataNoticia(String dataNoticia) {
        this.dataNoticia = dataNoticia;
    }

    public String getImagemNoticia() {
        return imagemNoticia;
    }

    public void setImagemNoticia(String imagemNoticia) {
        this.imagemNoticia = imagemNoticia;
    }

    public int getIdMidia() {
        return idMidia;
    }

    public void setIdMidia(int idMidia) {
        this.idMidia = idMidia;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }
}
