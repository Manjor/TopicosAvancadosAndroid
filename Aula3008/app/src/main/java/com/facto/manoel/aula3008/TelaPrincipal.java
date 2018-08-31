package com.facto.manoel.aula3008;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {
    private EditText login = null;
    private EditText password = null;
    private Button btnLogin = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        login = findViewById(R.id.editLogin);
        password = findViewById(R.id.editPassword);

        btnLogin = findViewById(R.id.btnEnter);



    }
    public void trataLogin(View botao){

        Log.i("INFO","Senha: " + password.getText().toString() );
        if(password.getText().toString().equals("1234")){
            Intent intencao = new Intent(TelaPrincipal.this,TelaPerfil.class);
            this.startActivity(intencao);
        }else{

        }
    }
}
