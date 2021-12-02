package com.example.newsapp.adapter;

import android.view.View;

import com.example.newsapp.fragment.BusinessFragment;
import com.example.newsapp.fragment.EntertenmentFragment;
import com.example.newsapp.fragment.HealthFragment;
import com.example.newsapp.fragment.HomeFragment;
import com.example.newsapp.fragment.SportsFragment;
import com.example.newsapp.fragment.TechnologyFragment;
import com.example.newsapp.fragment.cienceFragment;
import com.example.newsapp.model.Source;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class SectionPagerAdapter extends FragmentPagerAdapter {


    int tabcount;
    List<Source> sourcesmodels;
    public SectionPagerAdapter(@NonNull FragmentManager fm, int mtabCount) {
        super(fm,mtabCount);
        this.tabcount=mtabCount;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment=null;
        switch (position)
        {
            case 0:
                fragment= new HomeFragment();
                break;



            case 1:
                fragment= new SportsFragment(sourcesmodels);
                break;



            case 2:
                fragment= new HealthFragment();
                break;

            case 3:
                fragment= new BusinessFragment();
                break;

            case 4:
                fragment= new EntertenmentFragment();
                break;

            case 5:
                fragment= new cienceFragment();
                break;
            case 6:
                fragment= new TechnologyFragment();
                break;
        }


        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }



}
