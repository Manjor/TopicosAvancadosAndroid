package com.example.a06079050188.projetomaratonei;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);


        AbasInicio adaptar = new AbasInicio(getSupportFragmentManager());

        adaptar.adicionar(new MinhaLista() , "Primeira Aba");
        adaptar.adicionar(new SegundoFragment() , "Segunda Aba");
        adaptar.adicionar(new TerceiroFragment() , "Terceira Aba");

        ViewPager viewPager = (ViewPager) findViewById(R.id.abas_view_pager);
        viewPager.setAdapter(adaptar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.abas);
        tabLayout.setupWithViewPager(viewPager);

    }
}
