package com.example.a06079050188.projetomaratonei.Filmes;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a06079050188.projetomaratonei.R;

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

public class FragmentoFilmes extends android.support.v4.app.Fragment {


    View view;


    private RecyclerView recyclerFilmes;

    //Cria uma arrayList de filmes que irá receber os filmes da api
    private List<Filme> filmes = new ArrayList<>();

    //Define as strings que serão utilizadas para consumir a API
    //Token de Acesso a
    String baseApi = "https://api.themoviedb.org/3/";
    String urlImagensAPi = "https://image.tmdb.org/t/p/w500";
    String linguagem = "&language=pt-BR";
    String chaveApi = "?api_key=f814673a004bcd3dfd0e837cf1a0b020";

    String urlConsultaFilmes = baseApi + "movie/popular" + chaveApi + "&page=1" + linguagem;;
    String urlConsultaAcao = baseApi + "movie/now_playing" + chaveApi + "&page=1" + linguagem;

    //Declara os botões de Categorias de Filmes
    private Button btnCartaz;
    private Button btnAcao;
    private Button btnAventura;
    private Button btnComedia;
    private Button btnTerror;
    private Button btnGuerra;
    private Button btnFiccao;
    private Button btnDrama;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.filmesfragment,container,false);

        recyclerFilmes = view.findViewById(R.id.recycleFilmes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerFilmes.setLayoutManager(layoutManager);

        adicionaUrl(urlConsultaAcao);

        btnCartaz = view.findViewById(R.id.btnCartaz);
        btnCartaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionaUrl(urlConsultaFilmes);
            }
        });

        return view;

    }

    public void adicionaUrl(String url){
        MyTask task = new MyTask();
        task.execute(url);
    }


    public void adicionaSerieCard(String nomeFilme,String imagemFilme, int id)
    {
        Filme filme = new Filme(nomeFilme, imagemFilme ,id);
        this.filmes.add(filme);
    }

    class MyTask extends AsyncTask<String,Void,String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {


            String stringUrl = strings[strings.length - 1];
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
                String results = null;
                String nomeSerie = null;
                JSONArray jsonArray = null;

                try {
                    JSONObject jsonObject = new JSONObject(buffer.toString());
                    jsonArray = jsonObject.getJSONArray("results");

                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject e = jsonArray.getJSONObject(i);
                        String strinJsonNomeSerie = e.getString("title");
                        String backdropJsonSerie = e.getString("backdrop_path");
                        int idJsonSerie = e.getInt("id");
                        String urlImagemBanner = urlImagensAPi + backdropJsonSerie;

                        adicionaSerieCard(strinJsonNomeSerie,urlImagemBanner,idJsonSerie);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
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
            FilmesAdapter filmesAdapter = new FilmesAdapter( filmes );
            recyclerFilmes.setAdapter(filmesAdapter);

        }
    }


}
