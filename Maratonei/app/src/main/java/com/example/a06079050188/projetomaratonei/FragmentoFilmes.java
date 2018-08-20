package com.example.a06079050188.projetomaratonei;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentoFilmes extends android.support.v4.app.Fragment {
    View view;
    public FragmentoFilmes() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.filmesfragment,container,false);
        return view;
    }

}
