package com.example.fc20163243.myphome;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.fc20163243.myphome.PreferencesManeger.PreferencesManeger;

public class Logado extends AppCompatActivity implements DialogInterface.OnClickListener{

    TextView userName = null;
    Switch chave = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado);

        //recupera um dado vindo por parametro
        Bundle dicionario = getIntent().getExtras();
        String nomeUsuario = dicionario.getString("chaveLogin");

        userName = findViewById(R.id.textView6);
        userName.setText(nomeUsuario);
        chave = findViewById(R.id.switch1);
        chave.setChecked(PreferencesManeger.getValue(this));
    }

    public void voltarParaPrincipal (View botao) {

        //mensagem de alerta
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Aviso!");
        alert.setIcon(R.mipmap.ic_launcher_round);
        alert.setMessage("Tem certeza que deseja sair?");
        alert.setPositiveButton("sim", this); //cadastro de um objeto ouvinto do evento que esse Dialog vai gerar
        alert.setNegativeButton("não", this);
        alert.show();
//        finish();
    }
    public void verCardapio(View botao){
        Intent intent = new Intent(this,ListaComidas.class);
        this.startActivity(intent);
        this.finish();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int codBotao) {
        if (codBotao == DialogInterface.BUTTON_POSITIVE) {
            PreferencesManeger.salvar(this, chave.isChecked());//salvando a preferencia de notificações
            this.finish();
        }
    }
}
