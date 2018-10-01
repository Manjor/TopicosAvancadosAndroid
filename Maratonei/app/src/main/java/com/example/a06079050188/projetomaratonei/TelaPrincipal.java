package com.example.a06079050188.projetomaratonei;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a06079050188.projetomaratonei.Filmes.FragmentoFilmes;
import com.example.a06079050188.projetomaratonei.Noticias.FragmentoNoticias;
import com.example.a06079050188.projetomaratonei.Series.FragmentoSeries;

public class TelaPrincipal extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);



        tabLayout = (TabLayout) findViewById(R.id.tabLayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpage_id);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentoNoticias(),"Noticias");
        adapter.AddFragment(new FragmentoFilmes(),"Filmes");
        adapter.AddFragment(new FragmentoSeries(),"Series");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
