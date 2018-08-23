package com.example.a06079050188.projetomaratonei;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder>
{


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nome;
        private ImageView imagem;


        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }


}
