package com.example.fc20163243.myphome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    EditText campoLogin = null;
    EditText password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        campoLogin = findViewById(R.id.tela_principal_usuario);
        password = findViewById(R.id.tela_principal_senha);
    }

    public void trataLogin1(View botao){

//        if (password.getText().toString().equals("123")) {
//            Intent intencao = new Intent(this,
//                    Logado.class);
//            this.startActivity(intencao);
//        }else {
//            Toast.makeText(this,
//                    getResources().getString(R.string.msg_senha_invalida),
//                    Toast.LENGTH_SHORT).show();
//        }
    }

    public void trataLogin2(View button) {

        Intent intencao = new Intent(this, Logado.class);

        Bundle dicionario = new Bundle();
        dicionario.putString("chaveLogin", campoLogin.getText().toString());

        intencao.putExtras(dicionario);

        this.startActivity(intencao);

    }
}
