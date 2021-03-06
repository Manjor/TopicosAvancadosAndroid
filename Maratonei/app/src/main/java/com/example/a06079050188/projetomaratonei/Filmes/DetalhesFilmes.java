package com.example.a06079050188.projetomaratonei.Filmes;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.a06079050188.projetomaratonei.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DetalhesFilmes extends AppCompatActivity {

    //Define as strings que serão utilizadas para consumir a API
    //Token de Acesso a
    String baseApi = "https://api.themoviedb.org/3/";

    String urlImagensAPi = "https://image.tmdb.org/t/p/w500";
    String linguagem = "&language=pt-BR";
    String chaveApi = "f814673a004bcd3dfd0e837cf1a0b020";
    ImageView posterFilme;
    ImageView bannerFilme;
    VideoView trailer;
    TextView txtResumo;
    TextView txtTitle;
    TextView txtData;
    TextView txtHome;


    //Strings para captura de resultados
    String linkPoster = null;
    String linkBackdrop = null;
    String resumo = null;
    String title = null;
    String data = null;
    String homepage = null;
    String video = null;

    String urlDetalhesFilme = "";
    String urlVideoVideo = "";

    String retorno = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filmes);
        getSupportActionBar().hide();

        posterFilme = findViewById(R.id.posterFilme);
        bannerFilme = findViewById(R.id.bannerFilme);
        txtTitle = findViewById(R.id.titleFilme);
        txtData = findViewById(R.id.dataFilme);
        txtResumo = findViewById(R.id.resumoFilme);
        trailer = findViewById(R.id.videoTrailer);
        txtHome = findViewById(R.id.txtHomepage);



        int idFilme = this.getIntent().getIntExtra("id",0);
        //Verifica se foi recebido algum valor pelo Intent
        Log.i("INFO","Recebido: " + idFilme);

        MyTask task = new MyTask();
        MyTask task2 = new MyTask();
         urlDetalhesFilme = baseApi + "movie/" + idFilme +"?api_key=" + chaveApi + linguagem;
         urlVideoVideo = baseApi + "movie/" + idFilme + "/videos" + "?api_key=" + chaveApi + linguagem;

        List<String> strings = new ArrayList<>();

        strings.add(urlDetalhesFilme);
        strings.add(urlVideoVideo);

        task2.execute(strings.get(1).toString());
        task.execute(strings.get(0).toString());

    }
    class MyTask extends AsyncTask<String,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            String stringUrl = strings[0];




            StringBuffer buffer = new StringBuffer();

            if(stringUrl.contains(urlVideoVideo))
            {
                InputStream inputStream = null;
                InputStreamReader inputStreamReader = null;


                try {
                    URL url = new URL(stringUrl);
                    //Faz a requisição, abre a conexão
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

                    //Recupera os dados em Bytes
                    inputStream = conexao.getInputStream();

                    //inputStreamReader lê os dados em Bytes e decodifica para caracteres
                    inputStreamReader = new InputStreamReader(inputStream);

                    //Objeto utilizado para leitura dos caracteres do InputStreamReader
                    BufferedReader reader = new BufferedReader(inputStreamReader);


                    String linha = "";

                    while ((linha = reader.readLine()) != null) {

                        buffer.append(linha);
                    }

                    JSONArray jsonArray = null;
                    try {
                        JSONObject jsonObject = new JSONObject(buffer.toString());
                        jsonArray = jsonObject.getJSONArray("results");

                        JSONObject posicao = jsonArray.getJSONObject(0);
                        video = posicao.getString("key").toString();

                        Log.i("INFO","KEY: " + video);
                        retorno = "videoSucesso";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("INFO","Segundo Processamento Realizado: " + urlVideoVideo);
            }
            if(stringUrl.contains(urlDetalhesFilme)){

                InputStream inputStream = null;
                InputStreamReader inputStreamReader = null;


                try {
                    URL url = new URL(stringUrl);
                    //Faz a requisição, abre a conexão
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

                    //Recupera os dados em Bytes
                    inputStream = conexao.getInputStream();

                    //inputStreamReader lê os dados em Bytes e decodifica para caracteres
                    inputStreamReader = new InputStreamReader(inputStream);

                    //Objeto utilizado para leitura dos caracteres do InputStreamReader
                    BufferedReader reader = new BufferedReader(inputStreamReader);


                    String linha = "";

                    while ((linha = reader.readLine()) != null) {

                        buffer.append(linha);
                    }

                    try {
                        JSONObject jsonObject = new JSONObject(buffer.toString());

                        linkPoster = jsonObject.getString("poster_path");

                        linkBackdrop = jsonObject.getString("backdrop_path");

                        resumo = jsonObject.getString("overview");
                        title = jsonObject.getString("title");
                        data = jsonObject.getString("release_date");
                        homepage = jsonObject.getString("homepage");

                        retorno = "detalhesSucesso";

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
                //return buffer.toString();
            return retorno;

        }

        @Override
        protected void onPostExecute(String resultado) {

            super.onPostExecute(resultado);

            try{
                if (retorno.contains("videoSucesso")) {
                    Uri src = Uri.parse(video);
                    trailer.setVideoURI(src);
                }

            if (retorno.contains("detalhesSucesso")) {
                txtTitle.setText(title);
                txtData.setText(data);
                txtResumo.setText(resumo);
                txtHome.setText("Homepage: " + homepage);
                Picasso.get().load(urlImagensAPi + linkPoster).into(posterFilme);
                Picasso.get().load(urlImagensAPi + linkBackdrop).into(bannerFilme);
            }
        }catch (Exception e)
            {
                Log.i("INFO", "Erro no processamento de componentes");
            }

        }
    }
}
