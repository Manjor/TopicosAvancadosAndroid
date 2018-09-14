package com.example.fc20163243.myphome.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fc20163243.myphome.Classes.Food;
import com.example.fc20163243.myphome.R;
import com.example.fc20163243.myphome.ViewHolders.FoodHolder;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<FoodHolder> {


    private Context context;
    private ArrayList<Food> foodArrayList;

    public Adapter(Context context, ArrayList<Food> foodArrayList) {
        this.context = context;
        this.foodArrayList = foodArrayList;
    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cell = LayoutInflater.from(this.context).inflate(R.layout.celula_lista_comidas,parent,false);
        FoodHolder holder = new FoodHolder(cell);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {

        Food food = foodArrayList.get(position);
        holder.getNomeComida().setText(food.getName());
        holder.getStarComida().setNumStars(food.getNumStars());
        holder.getImageComida().setImageBitmap(food.getImage());

    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }
}
