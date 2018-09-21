package com.facto.manoel.tablayout;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toolbar;

import com.facto.manoel.tablayout.fragmentos.ConversasFragment;
import com.facto.manoel.tablayout.fragmentos.StatusFragment;

public class PrincipalActivity extends AppCompatActivity{


    private TabLayout tabLayout;
    private ViewPager viewPager;


    private ConversasFragment conversasFragment;
    private StatusFragment stausFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        setContentView(R.layout.activity_principal);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.pager);


        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.AddFragment(new ConversasFragment(), "Conversas");
        adapter.AddFragment(new StatusFragment(), "Status");
        adapter.AddFragment(new ConversasFragment(), "Conversas");
        adapter.AddFragment(new StatusFragment(), "Status");



        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }



//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        //Referencia dos Componentes
//
//        Toolbar  toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//
//        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
//
//        tabLayout.addTab(tabLayout.newTab().setText("Conversas"));
//        tabLayout.addTab(tabLayout.newTab().setText("Status"));
//        tabLayout.addTab(tabLayout.newTab().setText("Chamadas"));
//
//        viewPager = (ViewPager) findViewById(R.id.pager);
//
//
//        tabTalks =findViewById(R.id.talks);
//        tabStatus = findViewById(R.id.status);
//        tabCalls = findViewById(R.id.calls);
//
//
//
//        conversasFragment = new ConversasFragment();
//        stausFragment = new StatusFragment();
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frameLayout, conversasFragment);
//        transaction.commit();
//
//        tabTalks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.frameLayout, conversasFragment);
//                transaction.commit();
//                Log.i("INFO","CLicou");
//
//            }
//        });
////
//        tabStatus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.frameLayout, stausFragment);
//                transaction.commit();
//
//            }
//        });

}
