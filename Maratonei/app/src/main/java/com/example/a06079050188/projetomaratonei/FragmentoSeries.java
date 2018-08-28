package com.example.a06079050188.projetomaratonei;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FragmentoSeries extends android.support.v4.app.Fragment {
    //Cria uma referência de View
    View view;
    //Cria a instancia dos Atributos

    private RecyclerView recyclerView;

    private List<Serie> series;

    //Define as strings que serão utilizadas para consumir a API
    //Token de Acesso a
    String baseApi = "https://api.themoviedb.org/3/";
    String urlImagensAPi = "https://image.tmdb.org/t/p/original";
    String linguagem = "&language=pt-BR";
    String chaveApi = "f814673a004bcd3dfd0e837cf1a0b020";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.seriesfragment,container,false);


        recyclerView = view.findViewById(R.id.recycleView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        //Define o Layout do recycleView
        recyclerView.setLayoutManager(layoutManager);

        //Define o adapter
        SeriesAdapter seriesAdapter = new SeriesAdapter();
        recyclerView.setAdapter(seriesAdapter);





        MyTask task = new MyTask();
        String urlConsultaSeriesPopulares = baseApi + "tv/popular?api_key=" + chaveApi + "&page=1";

        task.execute(urlConsultaSeriesPopulares);

        return view;
    }

    public void preparaCardSeries(){
        Serie serie = new Serie();
    }


    class MyTask extends AsyncTask<String,Void,String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {


            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;

            StringBuffer buffer = null;

            try {
                URL url = new URL(stringUrl);
                //Faz a requisição, abre a conexão
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();



                //Recupera os dados em Bytes
                inputStream = conexao.getInputStream();

                //inputStreamReader lê os dados em Bytes e decodifica para caracteres
                inputStreamReader = new InputStreamReader( inputStream );

                //Objeto utilizado para leitura dos caracteres do InputStreamReader
                BufferedReader reader = new BufferedReader( inputStreamReader );

                buffer = new StringBuffer();
                String linha = "";

               while(( linha = reader.readLine()) != null ){

                   buffer.append( linha );

               }



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);

            //Picasso.get().load(urlBannerFilme + banner).into(imageView);

        }
    }



}
