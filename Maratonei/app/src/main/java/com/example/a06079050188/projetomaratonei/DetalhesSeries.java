package com.example.a06079050188.projetomaratonei;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

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
import java.net.URL;

public class DetalhesSeries extends AppCompatActivity {

    //Define as strings que serão utilizadas para consumir a API
    //Token de Acesso a
    String baseApi = "https://api.themoviedb.org/3/";

    String urlImagensAPi = "https://image.tmdb.org/t/p/w500";
    String linguagem = "&language=pt-BR";
    String chaveApi = "f814673a004bcd3dfd0e837cf1a0b020";
    ImageView posterSerie;
    TextView txtResumo;
    TextView txtNome;
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_series);

        int idSerie = this.getIntent().getIntExtra("id",0);
        //Verifica se foi recebido algum valor pelo Intent
        Log.i("INFO","Recebido: " + idSerie);



        MyTask task = new MyTask();
        String urlDetalhesSerie = baseApi + "tv/" + idSerie +"?api_key=" + chaveApi + linguagem;

        task.execute(urlDetalhesSerie);

    }



    class MyTask extends AsyncTask<String,Void,String> {


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

            String linkPoster = null;
            String resumo = null;
            String nome = null;
            String data = null;

            try {
                JSONObject jsonObject = new JSONObject(resultado);

                linkPoster = jsonObject.getString("poster_path");
                resumo = jsonObject.getString("overview");
                nome = jsonObject.getString("name");
                data = jsonObject.getString("first_air_date");
                    /*JSONObject e = jsonArray.getJSONObject(i);
                    String strinJsonNomeSerie = e.getString("name");
                    String backdropJsonSerie = e.getString("backdrop_path");
                    int idJsonSerie = e.getInt("id");
                    String urlImagemBanner = urlImagensAPi + backdropJsonSerie;

                    adicionaSerieCard(strinJsonNomeSerie,urlImagemBanner,idJsonSerie);*/

                posterSerie = findViewById(R.id.imgPosterSerie);
                txtResumo = findViewById(R.id.txtResumo);
                txtNome = findViewById(R.id.txtNome);
                txtData = findViewById(R.id.txtData);
                txtResumo.setText(resumo);
                txtNome.setText(nome);
                txtData.setText(data);
                Picasso.get().load(urlImagensAPi + linkPoster).into(posterSerie);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            /*SeriesAdapter seriesAdapter = new SeriesAdapter( series );

            recyclerView.setAdapter(seriesAdapter);

            Log.i("INFO","JSON: " + jsonArray.toString());*/


        }
    }


}
