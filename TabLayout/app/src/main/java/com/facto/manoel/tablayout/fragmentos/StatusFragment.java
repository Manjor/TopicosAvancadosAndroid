package com.facto.manoel.tablayout.fragmentos;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facto.manoel.tablayout.AdapterConversas;
import com.facto.manoel.tablayout.AdapterStatus;
import com.facto.manoel.tablayout.Conversas.Conversas;
import com.facto.manoel.tablayout.R;
import com.facto.manoel.tablayout.status.Status;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatusFragment extends Fragment {

    List<Status> statusList = new ArrayList<>();
    Bitmap bit = null;
    AdapterStatus adapterStatus = null;
    RecyclerView recyclerView;

    public StatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        statusList = new ArrayList<>();
        statusList.add(new Status(loadImage(R.drawable.download1),"Patricia"));
        statusList.add(new Status(loadImage(R.drawable.download1),"Patricia"));
        statusList.add(new Status(loadImage(R.drawable.download1),"Patricia"));
        statusList.add(new Status(loadImage(R.drawable.download1),"Patricia"));
        statusList.add(new Status(loadImage(R.drawable.download1),"Patricia"));
        statusList.add(new Status(loadImage(R.drawable.download1),"Patricia"));
        statusList.add(new Status(loadImage(R.drawable.download1),"Patricia"));


        adapterStatus = new AdapterStatus(getContext(),(ArrayList<Status>) statusList);
//
        View view = inflater.inflate(R.layout.fragment_conversas, container, false);
        recyclerView = view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapterStatus);


        // Inflate the layout for this fragment
        return view;

    }
    public Bitmap loadImage(int id){
        return BitmapFactory.decodeResource(getResources(),id);
    }

}
