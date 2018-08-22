package com.example.a06079050188.projetomaratonei;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpService extends AsyncTask <Void,Void, Filmes> {

    private final String filme;

    public HttpService(String filme){
        this.filme = filme;
    }

    @Override
    protected Filmes doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();

        if (this.filme != null)
        {
            try {
                URL url = new URL("https://viacep.com.br/ws/" + this.filme + "/json/" );
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.connect();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    resposta.append(scanner.next());
                }

            }
            catch (MalformedURLException e )
            {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return new Gson().fromJson(resposta.toString(), Filmes.class);
    }
}
