package com.example.a06079050188.projetomaratonei.Noticias;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a06079050188.projetomaratonei.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentoNoticias extends Fragment {

    private RecyclerView recyclerView;
    private View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.noticiasfragment,container,false);

        recyclerView = view.findViewById(R.id.recycleNoticia);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
