package com.facto.manoel.primeiroprojeto1608;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Metodo chamado quando o App é executado pela 1 vez
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Log.i("info","App Criado");
    }

    @Override
    public void onStop(){
        //Metodo chamado quando a aplicação sofre uma interrupcao externa
        super.onStop();
        Log.i("info","App Interrompida");
    }

    @Override
    public void onStart()
    {
        //Metodo chamado quando a aplicacao volta de uma interrupcao
        super.onStart();
        Log.i("info","App em Execucao");
    }


    @Override
    protected void onDestroy() {
        //Metodo que é chamado quando o aplicativo é totalmente encerrado
        super.onDestroy();
        Log.i("info","App Destruido");
    }

    @Override
    protected void onPause() {
        //Metodo chamado quando o aplicativo é totalmente encerrado
        super.onPause();
        Log.i("info","App Pausado");
    }

    @Override
    protected void onResume() {
        //Metodo chamado quando a aplicacao ja esta pronta para nacegacao
        super.onResume();
        Log.i("info","App Pronto para Uso");
    }
}
