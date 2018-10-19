package com.facto.manoel.mapaprojeto;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends FragmentPagerAdapter {


    private List<Fragment> fragmentList = new ArrayList<>();


    public Adapter(FragmentManager fm) {


        super(fm);
        fragmentList.add(new ProfileFragment());
        fragmentList.add(new MenuFoodFragment());
        fragmentList.add(new MapsFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
