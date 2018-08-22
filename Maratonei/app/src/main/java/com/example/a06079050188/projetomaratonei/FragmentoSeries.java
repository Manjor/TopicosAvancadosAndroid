package com.example.a06079050188.projetomaratonei;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class FragmentoSeries extends android.support.v4.app.Fragment {
    View view;
    private Button btnBuscaCep;
    EditText filme;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.seriesfragment,container,false);


        filme = view.findViewById(R.id.etMain_resposta);
        final TextView resposta = view.findViewById(R.id.etMain_resposta);
        btnBuscaCep =  view.findViewById(R.id.etMain_cep);
        btnBuscaCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Filmes retorno = new HttpService(filme.getText().toString()).execute().get();
                    resposta.setText(retorno.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }



}
