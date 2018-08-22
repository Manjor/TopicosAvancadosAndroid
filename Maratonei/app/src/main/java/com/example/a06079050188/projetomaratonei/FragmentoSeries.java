package com.example.a06079050188.projetomaratonei;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
import java.util.concurrent.ExecutionException;

public class FragmentoSeries extends android.support.v4.app.Fragment {
    View view;
    private Button botaoRecuperar;
    private TextView textoResultado;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.seriesfragment,container,false);

        botaoRecuperar = view.findViewById(R.id.buttonRecuperar);
        textoResultado = view.findViewById(R.id.textResultado);

        botaoRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyTask task = new MyTask();
                String utlApi = "https://viacep.com.br/ws/77001266/json/";

                task.execute(utlApi);

            }
        });

        return view;
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
            String logradouro = null;

            try {
                JSONObject jsonObject = new JSONObject(resultado);
                logradouro = jsonObject.getString("logradouro");


            } catch (JSONException e) {
                e.printStackTrace();
            }

            textoResultado.setText(logradouro);
        }
    }



}
