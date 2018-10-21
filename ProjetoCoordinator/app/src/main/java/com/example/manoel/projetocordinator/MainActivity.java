package com.example.manoel.projetocordinator;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private List<Card> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);
        appBarLayout = findViewById(R.id.appBar);
        toolbar =findViewById(R.id.toolbar);
        toolbar.setTitle("Teste");
        setSupportActionBar(toolbar);
        RecyclerView.LayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));
        cards.add(new Card("titulo"));

        AdapterCard adapterCard = new AdapterCard(this.cards);
        recyclerView.setAdapter(adapterCard);





    }
}
