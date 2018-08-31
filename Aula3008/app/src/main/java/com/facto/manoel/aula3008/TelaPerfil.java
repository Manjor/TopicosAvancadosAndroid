package com.facto.manoel.aula3008;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TelaPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);
    }

    public void trataVoltar(View botao){

            Intent intencao = new Intent(TelaPerfil.this, TelaPrincipal.class);
            Uri uri = Uri.parse("http://google.com");
            Intent it = new Intent(Intent.ACTION_VIEW);
            startActivity(it);


    }
}
