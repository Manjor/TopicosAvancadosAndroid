package com.example.fc20163243.myphome;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fc20163243.myphome.Adaptadores.Adapter;
import com.example.fc20163243.myphome.Classes.Food;

import java.util.ArrayList;
import java.util.List;

public class ListaComidas extends AppCompatActivity {

    List<Food> listFood = new ArrayList<>();
    Bitmap bit = null;
    Adapter adapter = null;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comidas);

        listFood = new ArrayList<>();
        listFood.add(new Food(3,"Comida 01", loadImage(R.drawable.california) ));
        listFood.add(new Food(3,"Comida 02", loadImage(R.drawable.mussarela) ));
        listFood.add(new Food(3,"Comida 03", loadImage(R.drawable.portuguesa) ));
        listFood.add(new Food(3,"Comida 04", loadImage(R.drawable.quatro_queijos) ));
        listFood.add(new Food(3,"Comida 05", loadImage(R.drawable.sucos) ));
        listFood.add(new Food(3,"Comida 06", loadImage(R.drawable.salada_de_frutas) ));
        listFood.add(new Food(3,"Comida 01", loadImage(R.drawable.california) ));
        listFood.add(new Food(3,"Comida 02", loadImage(R.drawable.mussarela) ));
        listFood.add(new Food(3,"Comida 03", loadImage(R.drawable.portuguesa) ));

        adapter = new Adapter(this, (ArrayList<Food>) listFood);
        //Obtem a referencia para o recycle
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Define o adaptador do Recycle
        recyclerView.setAdapter(adapter);

    }

    public Bitmap loadImage(int id){
        return BitmapFactory.decodeResource(getResources(),id);
    }
}
